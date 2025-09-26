package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String quizId;
    private String title;
    private String description;
    private List<Question> questions;
    private int passingScore;
    
    public Quiz(String quizId, String title, String description, int passingScore) {
        this.quizId = quizId;
        this.title = title;
        this.description = description;
        this.passingScore = passingScore;
        this.questions = new ArrayList<>();
    }
    
    // Getters and setters
    public String getQuizId() { return quizId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<Question> getQuestions() { return questions; }
    public int getPassingScore() { return passingScore; }
    
    public void addQuestion(Question question) {
        questions.add(question);
    }
    
    public int calculateScore(List<String> answers) {
        int score = 0;
        for (int i = 0; i < Math.min(questions.size(), answers.size()); i++) {
            if (questions.get(i).getCorrectAnswer().equals(answers.get(i))) {
                score++;
            }
        }
        return (score * 100) / questions.size();
    }
    
    @Override
    public String toString() {
        return String.format("Quiz: %s (%d questions, passing score: %d%%)", 
                title, questions.size(), passingScore);
    }
}
