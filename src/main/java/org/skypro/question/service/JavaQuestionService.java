package org.skypro.question.service;

import java.util.Collection;
import org.skypro.question.domain.Question;
import org.skypro.question.repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @Override
    public Question find(String question, String answer) {
        return javaQuestionRepository.find(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return javaQuestionRepository.getRandomQuestion();
    }
}
