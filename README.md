# Spring Secure E-Learning Platform

A full-stack E-Learning Platform built with Java, Spring Boot, React, and MySQL, featuring Spring Security with JWT authentication for safe access.
It provides role-based dashboards for students, mentors, and admins, along with secure payments through Razorpay and PayPal.
Users can browse courses, watch videos, download notes, and get real-time notifications in a simple and reliable way.

## Video
https://github.com/user-attachments/assets/71bef48f-81eb-46d4-8047-2e0eaaf6f2f6

## Features
🔐 Secure Login & Registration (with Google OAuth)  
🧑‍🎓 Role-Based Access (Student, Mentor, Admin)   
📚 Browse Free & Paid Courses   
💼 Mentor Dashboard (Course Management & Sales Tracking)  
🧑‍💻 Admin Panel for User & Content Control  
💳 Online Payments via Razorpay  
📩 Email Notifications (Login, OTP, Purchases)  
📥 Access Video Lectures, PDFs, and Downloads  
📜 Track Purchase History  
🔍 Advanced Course Filtering & Search  
🧾 JWT Token-Based API Security  
🔒 Encrypted Credentials (BCrypt)   
📱 Fully Responsive Frontend  
🧮 Analytics & Reports for Mentors/Admins  
📤 File Upload & Certificate Download  
📚 Course Details with Mentor Profiles  
📊 Audit Logs for Admin Actions  
⚙️ Scalable, Modular Code Structure  

## 🛠️ Tech Stack Used

Backend:
☕ Java
🌱 Spring Boot
🍃 Spring Security (with OAuth 2.0)
📦 Hibernate
🔄 RESTful APIs
🔐 JWT Authentication
🛡️ BCrypt Encryption

Frontend:
⚛️ React JS
🖼️ HTML / CSS
🎨 Bootstrap
🧠 JavaScript + jQuery

Database:
🐘 MySQL
🧩 JDBC
📊 Hibernate ORM

Security & Communication:
🔐 Spring Security
🧾 JWT Tokens
📧 Spring Mail Integration
🛡️ HTTPS
🔒 2FA (Two-Factor Authentication)

Payment Integration:
💳 Razorpay
💰 PayPal

Other:
📤 File Upload/Download API
📈 Audit Logs
🚀 Agile Development


## Screenshots
<img width="1919" height="1011" alt="Screenshot 2025-08-07 231236" src="https://github.com/user-attachments/assets/41b9b6d6-b3dc-4c2e-a8bc-f88344f226e5" />
<img width="1919" height="1010" alt="Screenshot 2025-08-07 231216" src="https://github.com/user-attachments/assets/634ded06-c62a-4cc0-8f73-58f56ad9ce80" />
<img width="1914" height="1015" alt="Screenshot 2025-08-07 231127" src="https://github.com/user-attachments/assets/0b5e389a-8dcb-4115-b24c-222a3beda472" />
<img width="1893" height="1016" alt="Screenshot 2025-08-07 231109" src="https://github.com/user-attachments/assets/6821f74b-067e-4f9a-b1cf-fd422fa6d7c6" />
<img width="1919" height="1015" alt="Screenshot 2025-08-07 224644" src="https://github.com/user-attachments/assets/91f23eb5-e27f-45b5-8445-728a9163f04a" />

## API Reference

#### Fetch all courses by user id
```http
  GET /api/course/fetch/course-user-id
```
#### To register new user

```http
  Post /api/user/register
```


## Contact / Author Info
👤 Developed by [Vijay Kumar](https://github.com/Vijay-kumar10)
📧 Email: kumar888985@gmail.com


## 📂 Maven-based Spring Boot Layered Architecture
```bash
lms-backend-master
│── .idea/                  # IDE specific settings
│── .mvn/                   # Maven wrapper files
│── .vscode/                # VS Code settings
│── src/
│   └── main/
│       ├── java/com/lms/
│       │   ├── config/         # Spring Boot configuration classes
│       │   ├── controller/     # REST API controllers
│       │   ├── dao/            # Data Access Layer (Repositories)
│       │   ├── dto/            # Data Transfer Objects
│       │   ├── entity/         # JPA entities (database models)
│       │   ├── exception/      # Custom exception handling
│       │   ├── filter/         # Security filters (JWT, logging, etc.)
│       │   ├── helper/         # Utility/helper classes
│       │   ├── interceptor/    # Request/response interceptors
│       │   ├── resource/       # API resource classes
│       │   ├── service/        # Business logic layer
│       │   └── utility/        # General utility functions
│       │
│       └── LmsBackendApplication.java   # Main Spring Boot application
│
└── resources/
    ├── application.properties           # Default application configuration
    ├── application-dev.properties       # Development environment config
    ├── application-prod.properties      # Production environment config
    └── log4j2-spring.xml                # Logging configuration
