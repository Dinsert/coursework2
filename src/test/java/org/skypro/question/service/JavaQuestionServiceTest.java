package org.skypro.question.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.skypro.question.domain.Question;
import org.skypro.question.repository.JavaQuestionRepository;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService(new JavaQuestionRepository());
    private final String question = "question";
    private final String answer = "answer";

    @Test
    void shouldReturnQuestionAtAdd() {
        Question actual = out.add(question, answer);
        Question excepted = new Question(question, answer);
        assertEquals(excepted, actual);
    }

    @Test
    void shouldReturnNullAtUnsuccessfulAdd() {
        out.add(question, answer);
        Question actual = out.add(question, answer);
        Question expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        out.add(question, answer);
        out.remove(question, answer);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullAtUnsuccessfulRemove() {
        out.add(question, answer);
        Question actual = out.remove(question, "invalidAnswer");
        Question expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnQuestionAtRemove() {
        out.add(question, answer);
        Question actual = out.remove(question, answer);
        Question excepted = new Question(question, answer);
        assertEquals(excepted, actual);
    }

    @Test
    void find() {
        out.add(question, answer);
        Question actual = out.find(question, answer);
        Question excepted = new Question(question, answer);
        assertEquals(excepted, actual);
    }

    @Test
    void shouldReturnNullAtUnsuccessfulFind() {
        out.add(question, answer);
        Question actual = out.find(question, "invalidAnswer");
        Question expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        out.add(question, answer);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question(question, answer));
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        out.add(question, answer);
        Question actual = out.getRandomQuestion();
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }
}