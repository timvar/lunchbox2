package codingschmoding.lunchbox.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import codingschmoding.lunchbox.domain.Question;
import codingschmoding.lunchbox.repository.QuestionRepository;

@Controller
public class QuestionController {
    
    @Autowired
    private QuestionRepository qrepository;

    // RESTful service to get all questions from database (Aarre)
    @GetMapping("/questions")
    public @ResponseBody List<Question> questionRest() {
        
        return (List<Question>) qrepository.findAll();
    }
    
    
    // RESTful service to get a question by id (Aarre)
    @GetMapping("/questions/{id}")
    public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long questionId ) {
        
        return qrepository.findById(questionId);
        
    }
    
}