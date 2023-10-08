package task4;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task4_QuizMain {
    static int currentQuestionIndex = 0;
    static int userScore = 0;
    static Question[] questions;
    static Timer timer;

    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }

    static void initializeQuestions() {
        // Initialize your array of questions here
        // Each question should have the question text, options, and correct answer
        questions = new Question[3];
        questions[0] = new Question("What is the pH value of the human body?", new String[]{"9.2 to 9.8", "7.0 to 7.8", "6.1 to 6.3", "5.4 to 5.6"}, 1);
        questions[1] = new Question("What is the name of the weak zone of the earth’s crust?", new String[]{"Seismic ", "Cosmic", "Formic", "Anaemic"}, 0);
        questions[2] = new Question("The green planet in the solar system is?", new String[]{"Mars", "Earth", "Venus", "Uranus"}, 3);
    }

    static void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz App Program");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime is up! Your next question is :");
                displayNextQuestion();
            }
        }, 10000); // 10 second timer

        displayNextQuestion();
    }

    static void displayNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            System.out.println("\n" + currentQuestion.getQuestionText());
            
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select your answer (1-" + currentQuestion.getOptions().length + "): ");
            int userAnswer = scanner.nextInt() - 1;
            
            if (userAnswer == currentQuestion.getCorrectAnswer()) {
                userScore++;
            }
            
            currentQuestionIndex++;
            timer.cancel();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime is up! Your next question is :");
                    displayNextQuestion();
                }
            }, 10000);
            
            displayNextQuestion();
        } else {
            endQuiz();
        }
    }

    static void endQuiz() {
        System.out.println("\nQuiz App Program Completed!");
        System.out.println("final score is: " + userScore + "/" + questions.length);
        System.out.println("Thank You. Hope you had fun");
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
