# E-Learning System

A comprehensive Java-based E-Learning Management System featuring user management, course delivery, progress tracking, and interactive assessments. Built with object-oriented design principles and file-based persistence.

## 🚀 Features

### 👨‍🎓 Student Features
- **User Registration & Authentication** - Secure account creation and login
- **Course Catalog** - Browse available courses with detailed descriptions
- **Course Enrollment** - Easy enrollment process with instant access
- **Multi-Media Content** - Support for text, video, and document materials
- **Interactive Quizzes** - Test knowledge with immediate feedback
- **Progress Tracking** - Real-time learning progress visualization
- **Completion Certificates** - Track course completion status

### 👨‍💼 Administrator Features
- **Course Management** - Create, edit, and delete courses
- **Content Creation** - Add various types of learning materials
- **Quiz Designer** - Build interactive assessments with scoring
- **User Management** - Monitor and manage student accounts
- **System Administration** - Full control over platform settings

### 🔧 Technical Features
- Object-oriented architecture with inheritance
- File-based data persistence
- Role-based access control (RBAC)
- Interactive console interface
- Comprehensive progress tracking
- Automated quiz scoring system

## 📁 Project Structure

```
E-Learning-System/
├── src/
│   ├── models/
│   │   ├── User.java           # Abstract base user class
│   │   ├── Student.java        # Student implementation
│   │   ├── Admin.java          # Administrator implementation
│   │   ├── Course.java         # Course data model
│   │   ├── Content.java        # Learning content model
│   │   ├── Quiz.java           # Quiz assessment model
│   │   ├── Question.java       # Quiz question model
│   │   └── CourseProgress.java # Progress tracking model
│   ├── services/
│   │   ├── UserService.java    # User management business logic
│   │   ├── CourseService.java  # Course management operations
│   │   └── QuizService.java    # Quiz management service
│   ├── utils/
│   │   └── DataPersistence.java # File-based storage utility
│   ├── ui/
│   │   └── ConsoleUI.java      # Console interface controller
│   └── ELearningSystem.java   # Main application entry point
├── data/                       # Auto-generated data directory
│   ├── users.dat              # User accounts storage
│   └── courses.dat            # Course data storage
├── bin/                       # Compiled class files
└── README.md                  # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **Java IDE** (Eclipse, IntelliJ IDEA, VS Code) or command line tools
- **Operating System** Windows, macOS, or Linux

### Quick Start

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/elearning-system.git
   cd elearning-system
   ```

2. **Compile the Project**
   ```bash
   # Navigate to source directory
   cd src
   
   # Compile all Java files
   javac -d ../bin *.java models/*.java services/*.java utils/*.java ui/*.java
   ```

3. **Run the Application**
   ```bash
   # Navigate to compiled classes
   cd ../bin
   
   # Execute main class
   java ELearningSystem
   ```

### Alternative IDE Setup
1. Import the project into your preferred Java IDE
2. Set the main class as `ELearningSystem`
3. Build and run the project

## 📖 Usage Guide

### Initial Setup
Upon first launch, the system automatically creates:
- **Default Admin Account**
  - Username: `admin`
  - Password: `admin123`
- **Data Directory** with necessary files

### For Students

1. **Registration Process**
   - Select "Register as Student" from main menu
   - Enter username, password, email, and full name
   - Login with new credentials

2. **Learning Journey**
   - Browse course catalog
   - Enroll in courses of interest
   - Access course materials sequentially
   - Mark content as completed
   - Take quizzes to test understanding
   - Monitor learning progress

### For Administrators

1. **Course Management**
   - Login with admin credentials
   - Create new courses with detailed information
   - Add multimedia content to courses
   - Design interactive quizzes

2. **System Administration**
   - Monitor student progress
   - Manage user accounts
   - Generate system reports

## 💾 Data Management

### File-Based Persistence
The system uses serialization for data storage:
- **`data/users.dat`** - User profiles and authentication data
- **`data/courses.dat`** - Course content and metadata

### Data Security
- Automatic data backup on each operation
- Graceful handling of file corruption
- Data validation and integrity checks

## 📚 Sample Content

The system includes pre-loaded courses:

### Java Programming Fundamentals
- Introduction to Java Programming
- Variables and Data Types
- Control Structures and Loops
- Interactive coding quizzes

### Web Development Basics
- HTML Fundamentals
- CSS Styling Techniques
- Responsive Design Principles

## 🔐 Security Features

- **Role-Based Access Control** - Students and administrators have different permissions
- **Secure Authentication** - Password-protected user accounts
- **Data Validation** - Input sanitization and validation
- **Session Management** - Secure user session handling

## 🚧 Extending the System

### Adding New Content Types
```java
// Extend the Content class
public class VideoContent extends Content {
    private String videoUrl;
    private int duration;
    // Implementation details
}
```

### Database Integration
Replace file-based storage with database:
1. Add JDBC dependencies
2. Create database schema
3. Implement DAO pattern
4. Update DataPersistence class

### Web Interface
- Implement Spring Boot web layer
- Create RESTful APIs
- Add frontend framework (React, Angular)

## 🐛 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| File permission errors | Ensure write permissions in application directory |
| Data corruption | Delete `.dat` files to reset system |
| Memory issues | Increase JVM heap size: `java -Xmx1024m ELearningSystem` |
| Login failures | Verify username/password or reset to default admin |

### Error Codes
- **E001**: Data file not found (normal on first run)
- **E002**: Invalid user credentials
- **E003**: Registration failed - username exists
- **E004**: Insufficient permissions for operation

## 🔮 Future Roadmap

- [ ] **Web-Based Interface** - Modern responsive web UI
- [ ] **Database Integration** - MySQL/PostgreSQL support
- [ ] **Video Streaming** - Built-in video player with controls
- [ ] **Discussion Forums** - Student interaction features
- [ ] **Certificate System** - Automated certificate generation
- [ ] **Mobile App** - Native iOS/Android applications
- [ ] **Analytics Dashboard** - Advanced reporting and insights
- [ ] **API Integration** - RESTful web services
- [ ] **Multi-language Support** - Internationalization features
- [ ] **Cloud Deployment** - AWS/Azure hosting options

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Development Guidelines
- Follow Java naming conventions
- Add comprehensive JavaDoc comments
- Include unit tests for new features
- Maintain consistent code formatting

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - *Initial work* - [YourGitHub](https://github.com/D-Anisha)

## 🙏 Acknowledgments

- Java community for excellent documentation
- Open source contributors
- Educational institutions for inspiration

## 📞 Support

For support and questions:
- Create an [Issue](https://github.com/D-Anisha/E-Learning-System/issues)
- Email: support@elearningsystem.com
- Documentation: [Wiki](https://github.com/D-Anisha/E-Learning-System/wiki)

---

**⭐ Star this repository if you find it helpful!**
