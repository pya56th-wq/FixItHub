package com.fixithub;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FixItHubApplication {
  public static void main(String[] a) { SpringApplication.run(FixItHubApplication.class, a); }

  /** Creates one in-charge per category: e.g. cse@fixithub.edu / incharge123 */
  @Bean CommandLineRunner seed(UserRepo repo) {
    return args -> {
      var enc = new BCryptPasswordEncoder();
      for (Category c : Category.values()) {
        String email = c.name().toLowerCase() + "@fixithub.edu";
        if (repo.findByEmail(email) != null) continue;
        User u = new User();
        u.setName(c.getLabel() + " In-charge"); u.setEmail(email);
        u.setPassword(enc.encode("incharge123"));
        u.setRole(Role.INCHARGE); u.setCategory(c);
        repo.save(u);
      }
    };
  }
}
