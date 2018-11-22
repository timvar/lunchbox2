package codingschmoding.lunchbox.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import codingschmoding.lunchbox.domain.Question;
import codingschmoding.lunchbox.domain.QuestionOption;
import codingschmoding.lunchbox.repository.QuestionOptionRepository;
import codingschmoding.lunchbox.repository.QuestionRepository;

@Controller
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    
    // RESTful service to get all questions from database
    @GetMapping("/questions")
    public @ResponseBody List<Question> questionRest() {
        
        return (List<Question>) questionRepository.findAll();
    }
    
    
    // RESTful service to get a question by id
    @GetMapping("/questions/{id}")
    public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long questionId ) {
        
        return questionRepository.findById(questionId);
        
    }
    
    // RESTful service to save a question
    @PostMapping("/questions")
    @ResponseBody
    public Question saveQuestion(@RequestBody Question question) {
    	
    	questionRepository.save(question);
    	
        return question;
    }
    
    @GetMapping("/questionOptions")
    public @ResponseBody List<QuestionOption> questionOptions() {
        
        return (List<QuestionOption>) questionOptionRepository.findAll();
    }
    
}