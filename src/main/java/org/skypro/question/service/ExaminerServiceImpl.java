package org.skypro.question.service;

import java.util.Collection;
import java.util.HashSet;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.QuestionsOverflowException;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        Collection<Question> result = new HashSet<>();
        while (amount != result.size()) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
