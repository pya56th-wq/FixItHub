package com.fixithub;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
  List<Complaint> findByStudentOrderByCreatedAtDesc(User s);
  List<Complaint> findByCategoryOrderByCreatedAtDesc(Category c);
}
