package com.fixithub;
import lombok.*;
@Getter @RequiredArgsConstructor
public enum Category {
  CSE("CSE Department"), AIDS("AI & DS Department"), IT("IT Department"), ECE("ECE Department"),
  EEE("EEE Department"), MBA("MBA Department"), MCA("MCA Department"), OTHER("Other Department"),
  MANAGEMENT("Management (Administrative)"), HOSTEL("Hostel"), CAFE("Cafe");
  private final String label;
}
