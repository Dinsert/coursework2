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
import org.skypro.question.repository.JavaQuestionRepository;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
    @InjectMocks
    private JavaQuestionService out;
    private final String question = "question";
    private final String answer = "answer";
    private final Collection<Question> questions = new HashSet<>(List.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5")));

    @Test
    void add() {
        when(javaQuestionRepositoryMock.add(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.add(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        when(javaQuestionRepositoryMock.remove(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.remove(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void find() {
        when(javaQuestionRepositoryMock.find(question, answer)).thenReturn(new Question(question, answer));
        Question actual = out.find(question, answer);
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>(questions);
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        when(javaQuestionRepositoryMock.getRandomQuestion()).thenReturn(new Question(question, answer));
        Question actual = out.getRandomQuestion();
        Question expected = new Question(question, answer);
        assertEquals(expected, actual);
    }
}