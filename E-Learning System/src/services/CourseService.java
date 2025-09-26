package services;

import models.Course;
import models.Content;
import models.Quiz;
import models.Student;
import utils.DataPersistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class CourseService {
    private Map<String, Course> courses;
    private DataPersistence dataPersistence;
    
    public CourseService() {
        this.dataPersistence = new DataPersistence();
        this.courses = loadCourses();
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, Course> loadCourses() {
        Map<String, Course> loadedCourses = (Map<String, Course>) dataPersistence.loadData("courses.dat");
        if (loadedCourses == null) {
            loadedCourses = new HashMap<>();
            createSampleCourses(loadedCourses);
            saveCourses();
        }
        return loadedCourses;
    }
    
    private void createSampleCourses(Map<String, Course> courses) {
        // Sample Java Programming Course
        Course javaCourse = new Course("java-001", "Java Programming Fundamentals", 
                "Learn the basics of Java programming language", "Dr. Smith");
        
        javaCourse.addContent(new Content("content-001", "Introduction to Java", "TEXT", 
                "Java is a high-level, object-oriented programming language...", 1));
        javaCourse.addContent(new Content("content-002", "Variables and Data Types", "TEXT", 
                "In Java, variables are containers that hold data values...", 2));
        javaCourse.addContent(new Content("content-003", "Control Structures", "TEXT", 
                "Control structures determine the flow of program execution...", 3));
        
        courses.put(javaCourse.getCourseId(), javaCourse);
        
        // Sample Web Development Course
        Course webCourse = new Course("web-001", "Web Development Basics", 
                "Introduction to HTML, CSS, and JavaScript", "Prof. Johnson");
        
        webCourse.addContent(new Content("content-004", "HTML Fundamentals", "TEXT", 
                "HTML (HyperText Markup Language) is the standard markup language...", 1));
        webCourse.addContent(new Content("content-005", "CSS Styling", "TEXT", 
                "CSS (Cascading Style Sheets) is used to style HTML elements...", 2));
        
        courses.put(webCourse.getCourseId(), webCourse);
    }
    
    private void saveCourses() {
        dataPersistence.saveData(courses, "courses.dat");
    }
    
    public Course createCourse(String title, String description, String instructor) {
        String courseId = "course-" + UUID.randomUUID().toString().substring(0, 8);
        Course course = new Course(courseId, title, description, instructor);
        courses.put(courseId, course);
        saveCourses();
        return course;
    }
    
    public List<Course> getAllActiveCourses() {
        return courses.values().stream()
                .filter(Course::isActive)
                .collect(Collectors.toList());
    }
    
    public Course getCourseById(String courseId) {
        return courses.get(courseId);
    }
    
    public boolean enrollStudent(Student student, String courseId) {
        Course course = courses.get(courseId);
        if (course != null && course.isActive()) {
            student.enrollInCourse(courseId);
            return true;
        }
        return false;
    }
    
    public void addContentToCourse(String courseId, Content content) {
        Course course = courses.get(courseId);
        if (course != null) {
            course.addContent(content);
            saveCourses();
        }
    }
    
    public void addQuizToCourse(String courseId, Quiz quiz) {
        Course course = courses.get(courseId);
        if (course != null) {
            course.addQuiz(quiz);
            saveCourses();
        }
    }
    
    public boolean deleteCourse(String courseId) {
        if (courses.containsKey(courseId)) {
            courses.remove(courseId);
            saveCourses();
            return true;
        }
        return false;
    }
    
    public void updateCourse(Course course) {
        courses.put(course.getCourseId(), course);
        saveCourses();
    }
}
