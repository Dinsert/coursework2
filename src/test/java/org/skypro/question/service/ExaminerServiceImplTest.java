package org.skypro.question.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.QuestionsOverflowException;
import org.skypro.question.repository.JavaQuestionRepository;
import org.skypro.question.repository.MathQuestionRepository;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;
    private JavaQuestionService javaQuestionService;
    private MathQuestionService mathQuestionService;
    private ExaminerServiceImpl out;
    private Collection<Question> questions = new HashSet<>(List.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5")));

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService(javaQuestionRepositoryMock);
        mathQuestionService = new MathQuestionService(mathQuestionRepositoryMock);
        out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
        questions = new HashSet<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5")));
    }

    @Test
    void getQuestions() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        when(javaQuestionRepositoryMock.getRandomQuestion()).thenReturn(new Question("question1", "answer1"),
                                                                        new Question("question2", "answer2"),
                                                                        new Question("question3", "answer3"),
                                                                        new Question("question5", "answer5"),
                                                                        new Question("question6", "answer6"));
        when(mathQuestionRepositoryMock.getAll()).thenReturn(questions);
        when(mathQuestionRepositoryMock.getRandomQuestion()).thenReturn(new Question("question4", "answer4"));
        Collection<Question> actual = out.getQuestions(6, null);
        Collection<Question> expected = new HashSet<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5"),
                new Question("question6", "answer6")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowQuestionsOverflowExceptionAtGetQuestions() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        assertThrows(QuestionsOverflowException.class, () -> out.getQuestions(6, null));
    }
}