package org.skypro.question.service;

import java.util.Collection;
import java.util.HashSet;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.QuestionsOverflowException;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        Collection<Question> result = new HashSet<>();
        int count = 0;
        while (amount != count) {
            if (result.add(javaQuestionService.getRandomQuestion())) {
                count++;
            }
            if (result.add(mathQuestionService.getRandomQuestion())) {
                count++;
            }
        }
        return result;
    }
}
