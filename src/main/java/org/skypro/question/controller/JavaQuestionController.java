package org.skypro.question.controller;

import java.util.Collection;
import org.skypro.question.domain.Question;
import org.skypro.question.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(question,answer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.find(question,answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

}
