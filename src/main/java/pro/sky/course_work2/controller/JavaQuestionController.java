package pro.sky.course_work2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work2.domain.Question;
import pro.sky.course_work2.service.QuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add (@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping
    public Collection <Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question remove (@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
