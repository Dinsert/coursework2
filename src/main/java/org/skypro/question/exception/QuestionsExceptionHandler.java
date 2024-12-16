package org.skypro.question.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QuestionsExceptionHandler {

    @ExceptionHandler(QuestionsOverflowException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handelQuestionsOverflow(QuestionsOverflowException e) {
        return e.getMessage();
    }
}
