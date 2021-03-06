package org.fundacionjala.app.quizz.console;

import java.util.Scanner;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;

public class QuizUIMenu {

    public Quiz handleCreateQuiz() {
        String title = askQuizTitle();
        Quiz quiz = new Quiz(title);
        boolean shouldExit = false;

        do {
            showMenu();
            char option = readOption();
            switch (option) {
                case '1':
                    Question question = QuestionUIMenu.handleCreateQuestion();
                    quiz.addQuestion(question);
                    break;
                case '0':
                    shouldExit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!shouldExit);

        return quiz;
    }

    private char readOption() {
        System.out.print("> ");
		Scanner in = new Scanner(System.in);
        return in.nextLine().trim().charAt(0);
    }

    private void showMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a new question");
        System.out.println("0. Finish");
    }

    private String askQuizTitle() {
        System.out.println("Type the quiz title");
        System.out.print("> ");
		Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
