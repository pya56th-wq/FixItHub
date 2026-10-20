# FixItHub

> Report it. Route it. Resolve it.

FixItHub is a web-based complaint management system designed for educational institutions. Students can submit complaints under the appropriate category, and the system automatically routes them to the responsible in-charge. Complaint status updates and resolution details are then provided through a secure role-based workflow.

![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-UI-green)

---

## Overview

Managing student complaints manually can be time-consuming and inefficient. FixItHub streamlines the process by providing a centralized system where complaints can be submitted, tracked, assigned to the appropriate department, and resolved efficiently.

---

## Key Features

- Student registration and login
- Secure password storage using BCrypt hashing
- Department-wise complaint categorization
- Automatic routing to the appropriate in-charge
- Complaint status tracking
- Resolution notes from in-charges
- Student notifications for resolved complaints
- Role-based access control
- MySQL database integration

---

## Complaint Categories

- CSE
- AIDS
- IT
- ECE
- EEE
- MBA
- MCA
- Other Department
- Management
- Hostel
- Cafe

---

## Tech Stack

| Component | Technology |
|------------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3.3 |
| Frontend | Thymeleaf, HTML5, CSS3 |
| Database | MySQL 8 |
| ORM | Hibernate |
| Security | BCrypt |
| Build Tool | Maven |

---

## System Workflow

1. Student registers and logs in.
2. Student submits a complaint.
3. Complaint is automatically assigned to the relevant department.
4. The in-charge reviews the complaint.
5. The complaint is resolved with a resolution note.
6. The student receives the updated complaint status.

---

## Installation

### Prerequisites

- Java 17 or later
- Maven
- MySQL 8+

### Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/FixItHub.git
cd FixItHub
```

### Configure Database

Update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fixithub
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run the Application

```bash
mvn spring-boot:run
```

Open:

```text
http://localhost:8080
```

---

## Future Enhancements

- Email notifications
- SMS notifications
- AI-based complaint categorization
- Analytics dashboard
- File and image attachments
- Mobile application support

---

## Author

**Priya Tharshini S**

Computer Science Engineering Student

Arunachala College of Engineering for Women

🔗 LinkedIn: https://www.linkedin.com/in/priya-tharshini

🔗 GitHub: https://github.com/pya56th-wq

---

⭐ Feel free to explore, fork, or contribute to this project.
