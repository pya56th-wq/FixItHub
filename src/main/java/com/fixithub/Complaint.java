package com.fixithub;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity @Getter @Setter
public class Complaint {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String title;
  @Column(length=2000) private String description;
  @Enumerated(EnumType.STRING) private Category category;
  @Enumerated(EnumType.STRING) private Status status = Status.PENDING;
  @ManyToOne private User student;
  @Column(length=1000) private String resolutionNote;
  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime resolvedAt;
  private boolean notified = false; // has the student been told it's resolved?
}
