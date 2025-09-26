package services;

import models.Quiz;
import models.Question;
import models.Student;

import java.util.List;
import java.util.Scanner;

public class QuizService {
    private Scanner scanner;
    
    public QuizService() {
        this.scanner = new Scanner(System.in);
    }
    
    public int takeQuiz(Quiz quiz, Student student) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("QUIZ: " + quiz.getTitle());
        System.out.println("Description: " + quiz.getDescription());
        System.out.println("Passing Score: " + quiz.getPassingScore() + "%");
        System.out.println("=".repeat(50));
        
        List<Question> questions = quiz.getQuestions();
        if (questions.isEmpty()) {
            System.out.println("No questions available for this quiz.");
            return 0;
        }
        
        System.out.println("\nPress Enter to start the quiz...");
        scanner.nextLine();
        
        int correctAnswers = 0;
        
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + " of " + questions.size());
            System.out.println(question.getQuestionText());
            
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }
            
            System.out.print("Your answer (1-" + options.size() + "): ");
            try {
                int answerIndex = Integer.parseInt(scanner.nextLine()) - 1;
                
                if (answerIndex >= 0 && answerIndex < options.size()) {
                    String selectedAnswer = options.get(answerIndex);
                    if (selectedAnswer.equals(question.getCorrectAnswer())) {
                        correctAnswers++;
                        System.out.println("✓ Correct!");
                    } else {
                        System.out.println("✗ Incorrect. The correct answer was: " + question.getCorrectAnswer());
                    }
                    
                    if (question.getExplanation() != null && !question.getExplanation().isEmpty()) {
                        System.out.println("Explanation: " + question.getExplanation());
                    }
                } else {
                    System.out.println("Invalid option selected. Marked as incorrect.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Marked as incorrect.");
            }
            
            System.out.println("-".repeat(30));
        }
        
        int score = (correctAnswers * 100) / questions.size();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("QUIZ RESULTS");
        System.out.println("=".repeat(50));
        System.out.println("Correct Answers: " + correctAnswers + "/" + questions.size());
        System.out.println("Score: " + score + "%");
        
        if (score >= quiz.getPassingScore()) {
            System.out.println("Status: PASSED ✓");
        } else {
            System.out.println("Status: FAILED ✗");
            System.out.println("You need " + quiz.getPassingScore() + "% to pass.");
        }
        System.out.println("=".repeat(50));
        
        // Update student's quiz score
        student.getCourseProgress().values().forEach(progress -> {
            progress.updateQuizScore(quiz.getQuizId(), score);
        });
        
        return score;
    }
}
