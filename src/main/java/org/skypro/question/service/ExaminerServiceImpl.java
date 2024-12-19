package org.skypro.question.service;

import java.util.Collection;
import java.util.HashSet;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.QuestionsOverflowException;
import org.skypro.question.repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionRepository javaQuestionRepository;

    public ExaminerServiceImpl(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionRepository.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        Collection<Question> result = new HashSet<>();
        while (amount != result.size()) {
            result.add(javaQuestionRepository.getRandomQuestion());
        }
        return result;
    }
}
