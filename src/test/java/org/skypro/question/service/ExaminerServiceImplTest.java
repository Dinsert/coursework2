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
import org.skypro.question.exception.QuestionsOverflowException;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    private final Collection<Question> questions = new HashSet<>(List.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5")));

    @Test
    void getQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("question1", "answer1"),
                                                                     new Question("question2", "answer2"),
                                                                     new Question("question3", "answer3"));
        Collection<Question> actual = out.getQuestions(3, null);
        Collection<Question> expected = new HashSet<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowQuestionsOverflowExceptionAtGetQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        assertThrows(QuestionsOverflowException.class, () -> out.getQuestions(6, null));
    }
}