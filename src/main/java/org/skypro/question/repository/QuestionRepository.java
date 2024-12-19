package org.skypro.question.repository;

import java.util.Collection;
import org.skypro.question.domain.Question;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question remove(String question, String answer);

    Question find(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
