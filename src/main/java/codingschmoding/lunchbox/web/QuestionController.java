package codingschmoding.lunchbox.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;
import java.util.Optional;

import codingschmoding.lunchbox.domain.Question;
import codingschmoding.lunchbox.domain.View;
import codingschmoding.lunchbox.repository.QuestionRepository;
import codingschmoding.lunchbox.repository.QuestionTypeRepository;
import codingschmoding.lunchbox.repository.SurveyRepository;

@Controller
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionrepository;
    
    @Autowired
    private QuestionTypeRepository questiontyperepository;
    
    @Autowired
    private SurveyRepository surveyrepository;
    
    // RESTful service to get all questions from database
    @JsonView(View.QuestionSumFilter.class)
    @GetMapping("/questions")
    public @ResponseBody List<Question> questionRest() {
        
        return (List<Question>) questionrepository.findAll();
    }
    
    
    // RESTful service to get a question by id
    @GetMapping("/questions/{id}")
    public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long questionId ) {
        
        return questionrepository.findById(questionId);
        
    }
    
    
    @RequestMapping(value="/addquestion")
    public String addQuestion(Model model) {
    		model.addAttribute("question", new Question());
    		model.addAttribute("questionTypes", questiontyperepository.findAll());
    		model.addAttribute("surveys", surveyrepository.findAll());
 
    		return "createSurvey";
    }
    
	// Save new question
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveQuestionHtml(Question question) {
		//System.out.println("question.content: "+question.getQuestionContent()+ " question.id: "+question.getQuestionId());
		questionrepository.save(question);
		return "login";
	}

    
    // RESTful service to save a question
    @PostMapping("/questions")
    @ResponseBody
    public Question saveQuestion(@RequestBody Question question) {
    	
    	questionrepository.save(question);
    	
        return question;
    }
    
}