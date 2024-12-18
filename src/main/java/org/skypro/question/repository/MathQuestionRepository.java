package org.skypro.question.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.skypro.question.domain.Question;
import org.springframework.stereotype.Repository;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questionSet;

    public MathQuestionRepository() {
        this.questionSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        if (questionSet.add(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        Question result = new Question(question, answer);
        if (questionSet.remove(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Question find(String question, String answer) {
        Question result = new Question(question, answer);
        if (questionSet.contains(result)) {
            return result;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questionSet);
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}
