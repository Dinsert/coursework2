package org.skypro.question.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.question.domain.Question;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;
    @InjectMocks
    private MathQuestionService out;
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
        when(mathQuestionRepositoryMock.add(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.add(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        when(mathQuestionRepositoryMock.remove(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.remove(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void find() {
        when(mathQuestionRepositoryMock.find(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.find(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(questions);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>(questions);
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        when(mathQuestionRepositoryMock.getRandomQuestion()).thenReturn(new Question(question, answer));
        Question actual = out.getRandomQuestion();
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }
}