# E-Learning System

A comprehensive Java-based E-Learning System with user management, course delivery, and progress tracking.

## Features

### For Students
- User registration and authentication
- Browse course catalog
- Enroll in courses
- View course content (text, video, documents)
- Take interactive quizzes
- Track learning progress
- View completion status

### For Administrators
- Complete course management
- Add/edit/delete courses
- Create course content
- Design interactive quizzes
- User management
- System administration

### Technical Features
- Object-oriented design with proper inheritance
- File-based data persistence
- Role-based access control
- Interactive console interface
- Progress tracking and reporting
- Quiz system with scoring

## Project Structure

src/
├── models/
│   ├── User.java           # Abstract base user class
│   ├── Student.java        # Student user implementation
│   ├── Admin.java          # Administrator user implementation
│   ├── Course.java         # Course model
│   ├── Content.java        # Course content model
│   ├── Quiz.java           # Quiz model
│   ├── Question.java       # Quiz question model
│   └── CourseProgress.java # Progress tracking model
├── services/
│   ├── UserService.java    # User management service
│   ├── CourseService.java  # Course management service
│   └── QuizService.java    # Quiz management service
├── utils/
│   └── DataPersistence.java # File-based data storage
├── ui/
│   └── ConsoleUI.java      # Console user interface
└── ELearningSystem.java   # Main application entry point


## Installation and Setup

1. **Prerequisites**
   - Java Development Kit (JDK) 8 or higher
   - Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or command line

2. **Compilation**
   \```bash
   # Navigate to the src directory
   cd src
   
   # Compile all Java files
   javac -d ../bin *.java models/*.java services/*.java utils/*.java ui/*.java
   \```

3. **Running the Application**
   \```bash
   # Navigate to the bin directory
   cd ../bin
   
   # Run the main class
   java ELearningSystem
   \```

## Usage Guide

### First Time Setup
1. Run the application
2. The system creates a default admin account:
   - Username: `admin`
   - Password: `admin123`

### Student Registration
1. Choose "Register as Student" from the main menu
2. Provide username, password, email, and full name
3. Login with your new credentials

### Course Management (Admin)
1. Login as admin
2. Create courses with title, description, and instructor
3. Add content to courses (text, video, documents)
4. Create quizzes with multiple-choice questions

### Learning Experience (Student)
1. Browse the course catalog
2. Enroll in desired courses
3. View course content sequentially
4. Mark content as completed
5. Take quizzes to test knowledge
6. Track your progress

## Data Storage

The system uses file-based persistence:
- `data/users.dat` - User accounts and profiles
- `data/courses.dat` - Course information and content

Data files are automatically created in the `data/` directory.

## Sample Data

The system includes sample courses:
1. **Java Programming Fundamentals**
   - Introduction to Java
   - Variables and Data Types
   - Control Structures

2. **Web Development Basics**
   - HTML Fundamentals
   - CSS Styling

## Key Features Explained

### Role-Based Access Control
- **Students**: Can browse, enroll, learn, and take quizzes
- **Admins**: Full system management capabilities

### Progress Tracking
- Automatic progress calculation based on completed content
- Quiz scores tracking
- Overall course completion percentage

### Interactive Quizzes
- Multiple-choice questions
- Immediate feedback
- Passing score requirements
- Detailed explanations

### Data Persistence
- All data automatically saved to files
- Persistent across application restarts
- Serialization-based storage system

## Extending the System

### Adding New Content Types
1. Extend the `Content` class
2. Update the `CourseService` to handle new types
3. Modify the UI to display new content appropriately

### Adding New User Roles
1. Create new user class extending `User`
2. Update `UserService` for registration
3. Add role-specific menu in `ConsoleUI`

### Database Integration
Replace `DataPersistence` class with database connectivity:
1. Add JDBC dependencies
2. Create database schema
3. Implement DAO pattern for data access

## Troubleshooting

### Common Issues
1. **File Permission Errors**: Ensure write permissions in application directory
2. **Data Corruption**: Delete `.dat` files to reset system
3. **Memory Issues**: Increase JVM heap size for large datasets

### Error Messages
- "Data file not found": Normal on first run, system creates new files
- "Invalid credentials": Check username/password combination
- "Registration failed": Username already exists

## Future Enhancements

- Web-based GUI interface
- Database integration (MySQL, PostgreSQL)
- Video streaming capabilities
- Discussion forums
- Certificate generation
- Mobile application support
- Advanced analytics and reporting

