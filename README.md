# FixItHub

> Report it. Route it. Resolve it.

FixItHub is a web-based complaint management system designed for educational institutions. Students can submit complaints under the appropriate category, and the system automatically routes them to the responsible in-charge. Complaint status and resolution updates are then provided to students through a role-based workflow.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-UI-green)

---

## Overview

Managing student complaints manually can lead to delays and communication gaps. FixItHub streamlines the process by providing a centralized platform where complaints are submitted, routed to the appropriate department, tracked, and resolved efficiently.

---

## Key Features

✅ Student Registration & Login

✅ Secure password storage using BCrypt hashing

✅ Department-wise complaint categorization

✅ Automatic complaint routing to the relevant in-charge

✅ Complaint status tracking

✅ Resolution notes from in-charges

✅ Student notifications for resolved complaints

✅ Role-based access control

✅ MySQL database integration

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
| Frontend | Thymeleaf, HTML, CSS |
| Database | MySQL 8 |
| ORM | Hibernate |
| Security | BCrypt |
| Build Tool | Maven |

---

## System Workflow

1. Student registers and logs in.
2. Student submits a complaint.
3. Complaint is assigned automatically to the relevant department.
4. In-charge reviews the complaint.
5. In-charge resolves it with a resolution note.
6. Student receives the updated status and resolution details.

---

## Screenshots

### Landing Page
_Add screenshot here_

### Student Dashboard
_Add screenshot here_

### In-Charge Dashboard
_Add screenshot here_

---

## Installation

### Prerequisites

- Java 17+
- Maven
- MySQL 8+

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/FixItHub.git
cd FixItHub
```

### Database Configuration

Update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fixithub
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run Application

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

---

## Future Improvements

- Email notifications
- SMS notifications
- Complaint analytics dashboard
- AI-powered category suggestions
- Attachment support
- Mobile application

---

## Author

**Priya Tharshini S**

Computer Science Engineering Student

Arunachala College of Engineering for Women

🔗 LinkedIn: https://www.linkedin.com/in/priya-tharshini

🔗 GitHub: https://github.com/pya56th-wq

---

⭐ If you found this project interesting, feel free to star the repository.
