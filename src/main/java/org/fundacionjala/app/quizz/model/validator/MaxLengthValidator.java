

package org.fundacionjala.app.quizz.model.validator;

import java.util.List;


public class MaxLengthValidator implements Validator<String, Integer> {
	
	private static final String ERROR_MESSAGE = "The length of the value must be greater than ";

	@Override
    public void validate(String value, Integer conditionValue, List<String> errors) {
        if (value.length() > conditionValue) {
            errors.add(ERROR_MESSAGE + conditionValue);
        }
    }

}
