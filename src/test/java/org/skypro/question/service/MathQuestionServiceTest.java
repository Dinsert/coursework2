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
import org.skypro.question.exception.MethodNotAllowedException;
import org.skypro.question.repository.JavaQuestionRepository;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
    @InjectMocks
    private MathQuestionService out;
    private final String question = "question";
    private final String answer = "answer";
    private final Collection<Question> questions =
            new HashSet<>(List.of(new Question("question", "answer")));

    @Test
    void shouldThrowMethodNotAllowedExceptionAtAdd() {
        assertThrows(MethodNotAllowedException.class, () -> out.add(question, answer));
    }

    @Test
    void shouldThrowMethodNotAllowedExceptionAtRemove() {
        assertThrows(MethodNotAllowedException.class, () -> out.remove(question, answer));
    }

    @Test
    void shouldThrowMethodNotAllowedExceptionAtFind() {
        assertThrows(MethodNotAllowedException.class, () -> out.find(question, answer));
    }

    @Test
    void shouldThrowMethodNotAllowedExceptionAtGetAll() {
        assertThrows(MethodNotAllowedException.class, () -> out.getAll());
    }

    @Test
    void getRandomQuestion() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        Question actual = out.getRandomQuestion();
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }
}