package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String courseId;
    private String title;
    private String description;
    private String instructor;
    private List<Content> contents;
    private List<Quiz> quizzes;
    private boolean isActive;
    
    public Course(String courseId, String title, String description, String instructor) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.contents = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.isActive = true;
    }
    
    // Getters and setters
    public String getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getInstructor() { return instructor; }
    public List<Content> getContents() { return contents; }
    public List<Quiz> getQuizzes() { return quizzes; }
    public boolean isActive() { return isActive; }
    
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setActive(boolean active) { this.isActive = active; }
    
    public void addContent(Content content) {
        contents.add(content);
    }
    
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }
    
    @Override
    public String toString() {
        return String.format("Course ID: %s\nTitle: %s\nInstructor: %s\nDescription: %s\nContents: %d\nQuizzes: %d",
                courseId, title, instructor, description, contents.size(), quizzes.size());
    }
}
