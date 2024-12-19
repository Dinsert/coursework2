package org.skypro.question.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.skypro.question.domain.Question;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();
    private final String question = "question";
    private final String answer = "answer";
    private Collection<Question> questions = new HashSet<>(List.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5")));

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void find() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getRandomQuestion() {
    }
}