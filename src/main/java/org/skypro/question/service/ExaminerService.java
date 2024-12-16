package org.skypro.question.service;

import java.util.Collection;
import org.skypro.question.domain.Question;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
