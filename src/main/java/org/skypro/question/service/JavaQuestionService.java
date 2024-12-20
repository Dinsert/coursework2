package org.skypro.question.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.skypro.question.domain.Question;
import org.springframework.stereotype.Service;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        if (questions.add(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        Question result = new Question(question, answer);
        if (questions.remove(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question find(String question, String answer) {
        Question result = new Question(question, answer);
        if (questions.contains(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}
