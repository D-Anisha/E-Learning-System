package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private static final long serialVersionUID = 1L;
    
    private List<String> enrolledCourses;
    private Map<String, CourseProgress> courseProgress;
    
    public Student(String userId, String username, String password, String email, String fullName) {
        super(userId, username, password, email, fullName);
        this.enrolledCourses = new ArrayList<>();
        this.courseProgress = new HashMap<>();
    }
    
    @Override
    public String getRole() {
        return "STUDENT";
    }
    
    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public Map<String, CourseProgress> getCourseProgress() { return courseProgress; }
    
    public void enrollInCourse(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
            courseProgress.put(courseId, new CourseProgress(courseId));
        }
    }
    
    public void updateProgress(String courseId, String contentId, boolean completed) {
        CourseProgress progress = courseProgress.get(courseId);
        if (progress != null) {
            progress.updateContentProgress(contentId, completed);
        }
    }
}
