package models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String questionId;
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String explanation;
    
    public Question(String questionId, String questionText, List<String> options, 
                   String correctAnswer, String explanation) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }
    
    // Getters and setters
    public String getQuestionId() { return questionId; }
    public String getQuestionText() { return questionText; }
    public List<String> getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getExplanation() { return explanation; }
    
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public void setOptions(List<String> options) { this.options = options; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
}
