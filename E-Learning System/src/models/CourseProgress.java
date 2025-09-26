package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CourseProgress implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String courseId;
    private Map<String, Boolean> contentProgress;
    private Map<String, Integer> quizScores;
    private double overallProgress;
    
    public CourseProgress(String courseId) {
        this.courseId = courseId;
        this.contentProgress = new HashMap<>();
        this.quizScores = new HashMap<>();
        this.overallProgress = 0.0;
    }
    
    public void updateContentProgress(String contentId, boolean completed) {
        contentProgress.put(contentId, completed);
        calculateOverallProgress();
    }
    
    public void updateQuizScore(String quizId, int score) {
        quizScores.put(quizId, score);
    }
    
    private void calculateOverallProgress() {
        if (contentProgress.isEmpty()) {
            overallProgress = 0.0;
            return;
        }
        
        long completedCount = contentProgress.values().stream()
                .mapToLong(completed -> completed ? 1 : 0)
                .sum();
        
        overallProgress = (double) completedCount / contentProgress.size() * 100;
    }
    
    // Getters
    public String getCourseId() { return courseId; }
    public Map<String, Boolean> getContentProgress() { return contentProgress; }
    public Map<String, Integer> getQuizScores() { return quizScores; }
    public double getOverallProgress() { return overallProgress; }
}
