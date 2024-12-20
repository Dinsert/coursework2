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
import org.skypro.question.repository.JavaQuestionRepository;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
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
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        when(javaQuestionRepositoryMock.getRandomQuestion()).thenReturn(new Question("question1", "answer1"),
                                                                        new Question("question2", "answer2"),
                                                                        new Question("question3", "answer3"));
        Collection<Question> actual = out.getQuestions(3);
        Collection<Question> expected = new HashSet<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowQuestionsOverflowExceptionAtGetQuestions() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        assertThrows(QuestionsOverflowException.class, () -> out.getQuestions(6));
    }
}