package codingschmoding.lunchbox.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import codingschmoding.lunchbox.domain.Response;
import codingschmoding.lunchbox.domain.View;
import codingschmoding.lunchbox.repository.ResponseRepository;

@Controller
public class ResponseController {
	
	
	  	@Autowired
	    private ResponseRepository rrepository;
	  
	  
	    // RESTful service to get all answers from database
	  	@JsonView(View.Summary.class)
	    @GetMapping("/responses")
	    public @ResponseBody List<Response> responseRest() {
	        
	        return (List<Response>) rrepository.findAll();
	    }
	    
	    
	    // RESTful service to get an answer by id
	    @GetMapping("/responses/{id}")
	    public @ResponseBody Optional<Response> findResponseRest(@PathVariable("id") Long responseId ) {
	        
	        return rrepository.findById(responseId);
	        
	    }

}