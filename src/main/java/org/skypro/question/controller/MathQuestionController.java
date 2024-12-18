package org.skypro.question.controller;

import java.util.Collection;
import org.skypro.question.domain.Question;
import org.skypro.question.service.MathQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exam/math")
@RestController
public class MathQuestionController {

    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(question, answer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.find(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return mathQuestionService.getAll();
    }
}
