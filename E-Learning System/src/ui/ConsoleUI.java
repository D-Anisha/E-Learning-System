package ui;

import models.*;
import services.*;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class ConsoleUI {
    private Scanner scanner;
    private UserService userService;
    private CourseService courseService;
    private QuizService quizService;
    private User currentUser;
    
    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
        this.courseService = new CourseService();
        this.quizService = new QuizService();
    }
    
    public void start() {
        System.out.println("=".repeat(60));
        System.out.println("         WELCOME TO E-LEARNING SYSTEM");
        System.out.println("=".repeat(60));
        
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                if (currentUser.getRole().equals("STUDENT")) {
                    showStudentMenu();
                } else if (currentUser.getRole().equals("ADMIN")) {
                    showAdminMenu();
                }
            }
        }
    }
    
    private void showLoginMenu() {
        System.out.println("\n--- LOGIN MENU ---");
        System.out.println("1. Login");
        System.out.println("2. Register as Student");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                login();
                break;
            case "2":
                registerStudent();
                break;
            case "3":
                System.out.println("Thank you for using E-Learning System!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        User user = userService.authenticate(username, password);
        if (user != null) {
            currentUser = user;
            System.out.println("Login successful! Welcome, " + user.getFullName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
    
    private void registerStudent() {
        System.out.println("\n--- STUDENT REGISTRATION ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        
        if (userService.registerStudent(username, password, email, fullName)) {
            System.out.println("Registration successful! You can now login.");
        } else {
            System.out.println("Registration failed. Username might already exist.");
        }
    }
    
    private void showStudentMenu() {
        Student student = (Student) currentUser;
        System.out.println("\n--- STUDENT DASHBOARD ---");
        System.out.println("Welcome, " + student.getFullName());
        System.out.println("1. Browse Course Catalog");
        System.out.println("2. My Enrolled Courses");
        System.out.println("3. View Progress");
        System.out.println("4. Take Quiz");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                browseCatalog();
                break;
            case "2":
                viewEnrolledCourses();
                break;
            case "3":
                viewProgress();
                break;
            case "4":
                takeQuiz();
                break;
            case "5":
                logout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
    private void showAdminMenu() {
        System.out.println("\n--- ADMIN DASHBOARD ---");
        System.out.println("Welcome, " + currentUser.getFullName());
        System.out.println("1. Manage Courses");
        System.out.println("2. Create New Course");
        System.out.println("3. Add Content to Course");
        System.out.println("4. Create Quiz");
        System.out.println("5. View All Users");
        System.out.println("6. Logout");
        System.out.print("Choose an option: ");
