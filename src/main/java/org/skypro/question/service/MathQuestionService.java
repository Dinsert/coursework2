package org.skypro.question.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.MethodNotAllowedException;
import org.skypro.question.repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class MathQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public MathQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Method doesn't work");
    }

    @Override
    public Question remove(String question, String answer) {
        throw new MethodNotAllowedException("Method doesn't work");
    }

    @Override
    public Question find(String question, String answer) {
        throw new MethodNotAllowedException("Method doesn't work");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Method doesn't work");
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(javaQuestionRepository.getAll());
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}
