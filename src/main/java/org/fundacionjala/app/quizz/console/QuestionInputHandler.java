package org.fundacionjala.app.quizz.console;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.fundacionjala.app.quizz.model.Question;

public class QuestionInputHandler {

    public Set<String> askQuestionValue(Question question) {
        System.out.println("Question: " + question.getTitle());
        return getAnswer(question);
    }

    private Set<String> getAnswer(Question question) {
        Set<String> answers = new HashSet<>();
        if (question.getType().getConfiguration().hasAdditionalData()) {
            answers.add(collectAnswerFromOptions(question));
        } else {
            System.out.print(question.getType().getName() + " value: ");
			Scanner in = new Scanner(System.in);
            String value = in.nextLine();
            answers.add(value);
        }

        return answers;
    }

    private String collectAnswerFromOptions(Question question) {
        String answer = null;

        while (true) {
            showOptions(question);
            char option = readOption();
            if (option == '0') {
                break;
            }
        }

        return answer;
    }

    private void showOptions(Question question) {
        System.out.println("Select an option: ");
        for (int index = 0; index < question.getAdditionalData().size(); index++) {
            System.out.printf("%d. %s" + System.lineSeparator(), index + 1, question.getAdditionalData().get(index));
        }
        System.out.println("0. To Finish");
    }

    private char readOption() {
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim().charAt(0);
    }
}
