package org.skypro.question.service;

import java.util.Collection;
import org.skypro.question.domain.Question;
import org.skypro.question.repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return mathQuestionRepository.remove(question, answer);
    }

    @Override
    public Question find(String question, String answer) {
        return mathQuestionRepository.find(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return mathQuestionRepository.getRandomQuestion();
    }
}
