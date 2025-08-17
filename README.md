
## 📂 Project Structure
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
