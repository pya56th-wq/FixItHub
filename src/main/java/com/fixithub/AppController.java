package com.fixithub;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller @RequiredArgsConstructor
public class AppController {
  private final UserRepo users;
  private final ComplaintRepo complaints;
  private final BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

  private User cur(HttpSession s) {
    Object id = s.getAttribute("uid");
    return id == null ? null : users.findById((Long) id).orElse(null);
  }

  @GetMapping("/") String splash() { return "splash"; }
  @GetMapping("/home") String home() { return "home"; }

  @GetMapping("/register") String reg(Model m) { m.addAttribute("user", new User()); return "register"; }

  @PostMapping("/register")
  String doReg(@ModelAttribute User u, Model m) {
    if (users.findByEmail(u.getEmail()) != null) { m.addAttribute("error", "Email already registered"); return "register"; }
    u.setRole(Role.STUDENT); u.setCategory(null);
    u.setPassword(enc.encode(u.getPassword()));
    users.save(u);
    return "redirect:/login?registered";
  }

  @GetMapping("/login") String login() { return "login"; }

  @PostMapping("/login")
  String doLogin(@RequestParam String email, @RequestParam String password, HttpSession s, Model m) {
    User u = users.findByEmail(email);
    if (u == null || !enc.matches(password, u.getPassword())) { m.addAttribute("error", "Invalid email or password"); return "login"; }
    s.setAttribute("uid", u.getId());
    return "redirect:/dashboard";
  }

  @GetMapping("/logout") String logout(HttpSession s) { s.invalidate(); return "redirect:/login"; }

  @GetMapping("/dashboard")
  String dash(HttpSession s, Model m) {
    User u = cur(s);
    if (u == null) return "redirect:/login";
    m.addAttribute("user", u);
    if (u.getRole() == Role.INCHARGE) {
      m.addAttribute("list", complaints.findByCategoryOrderByCreatedAtDesc(u.getCategory()));
      return "incharge";
    }
    List<Complaint> list = complaints.findByStudentOrderByCreatedAtDesc(u);
    List<Complaint> alerts = list.stream().filter(c -> c.getStatus() == Status.RESOLVED && !c.isNotified()).toList();
    m.addAttribute("alerts", alerts);
    alerts.forEach(c -> c.setNotified(true));   // shown once, then marked as seen
    complaints.saveAll(alerts);
    m.addAttribute("list", list);
    m.addAttribute("categories", Category.values());
    return "student";
  }

  @PostMapping("/complaints")
  String submit(@RequestParam String title, @RequestParam String description,
                @RequestParam Category category, HttpSession s) {
    User u = cur(s);
    if (u == null || u.getRole() != Role.STUDENT) return "redirect:/login";
    Complaint c = new Complaint();
    c.setTitle(title); c.setDescription(description); c.setCategory(category); c.setStudent(u);
    complaints.save(c);   // routed to the in-charge of this category automatically
    return "redirect:/dashboard";
  }

  @PostMapping("/complaints/{id}/resolve")
  String resolve(@PathVariable Long id, @RequestParam String note, HttpSession s) {
    User u = cur(s);
    Complaint c = complaints.findById(id).orElse(null);
    if (u == null || c == null || u.getRole() != Role.INCHARGE || u.getCategory() != c.getCategory()) return "redirect:/login";
    c.setStatus(Status.RESOLVED); c.setResolutionNote(note);
    c.setResolvedAt(LocalDateTime.now()); c.setNotified(false);  // triggers student notification
    complaints.save(c);
    return "redirect:/dashboard";
  }
}
