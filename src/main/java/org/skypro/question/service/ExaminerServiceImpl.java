package org.skypro.question.service;

import static java.util.Objects.*;

import java.util.Collection;
import java.util.HashSet;
import org.skypro.question.domain.Question;
import org.skypro.question.exception.QuestionsOverflowException;
import org.springframework.stereotype.Service;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount, String exam) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        if (isNull(exam)) {
            Collection<Question> result = new HashSet<>();
            int count = 0;
            while (amount != count) {
                if (result.add(javaQuestionService.getRandomQuestion())) {
                    count++;
                }
                if (result.add(mathQuestionService.getRandomQuestion())) {
                    count++;
                }
            }
            return result;
        }
        Collection<Question> java = getQuestionsByJava(amount, exam);
        Collection<Question> math = getQuestionsByMath(amount, exam);
        if (isNull(java)) {
            return math;
        }
        return java;
    }

    private Collection<Question> getQuestionsByJava(int amount, String exam) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        if (exam.equals("Java")) {
            Collection<Question> result = new HashSet<>();
            while (amount != result.size()) {
                result.add(javaQuestionService.getRandomQuestion());
            }
            return result;
        }
        return null;
    }

    private Collection<Question> getQuestionsByMath(int amount, String exam) {
        if (amount > mathQuestionService.getAll().size()) {
            throw new QuestionsOverflowException("Запрошено больше вопросов, чем есть в сервисе");
        }
        if (exam.equals("Math")) {
            Collection<Question> result = new HashSet<>();
            while (amount != result.size()) {
                result.add(mathQuestionService.getRandomQuestion());
            }
            return result;
        }
        return null;
    }
}
