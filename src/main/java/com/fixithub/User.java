package com.fixithub;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="users") @Getter @Setter
public class User {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  @Column(unique=true) private String email;
  private String rollNo;
  private String password;
  @Enumerated(EnumType.STRING) private Role role;
  @Enumerated(EnumType.STRING) private Category category; // only for incharges
}
