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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import codingschmoding.lunchbox.domain.Question;
import codingschmoding.lunchbox.domain.QuestionOption;
import codingschmoding.lunchbox.domain.QuestionSum;
import codingschmoding.lunchbox.domain.QuestionType;
import codingschmoding.lunchbox.domain.Response;
import codingschmoding.lunchbox.domain.Survey;
import codingschmoding.lunchbox.domain.View;
import codingschmoding.lunchbox.repository.QuestionOptionRepository;
import codingschmoding.lunchbox.repository.QuestionRepository;
import codingschmoding.lunchbox.repository.QuestionTypeRepository;
import codingschmoding.lunchbox.repository.SurveyRepository;

@Controller
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    
    @Autowired
    private SurveyRepository surveyRepository;
    
    /**
     *  RESTful service to get all questions WITH OPTIONS from database
     * @return
     */
    @JsonView(View.QuestionRestFilter.class)
    @GetMapping("/questions")
    public @ResponseBody List<QuestionSum> questionsWithOptionsRest() {
    	
    	List<QuestionSum> questionSum = new ArrayList<> ();
    	
    	Iterable <Question> questionsAll = questionRepository.findAll(); 
    	Iterable <QuestionOption> questionOptionsAll = questionOptionRepository.findAll();
    	
    	for (Question question : questionsAll) {
    		
    		QuestionSum questionSumItem = new QuestionSum();
    		
    		// private long questionSumId;
    		questionSumItem.setQuestionId(question.getQuestionId());
    		
    		//private String questionSumContent;
    		questionSumItem.setQuestionContent(question.getQuestionContent());

    		//private boolean questionOptionExist;
    		questionSumItem.setQuestionOptionExist(question.isQuestionOptionExist());
    		
    		//private QuestionType questionType;
    		questionSumItem.setQuestionType(question.getQuestionType());
    		
    		//private Survey survey;
    		questionSumItem.setSurvey(question.getSurvey());
    		
    		//private List<QuestionOption> questionOptions;
    		
    		List<QuestionOption> questionOptions = new ArrayList<> ();
    		
    		for (QuestionOption questionOption : questionOptionsAll) {
    			    			
    			if (questionOption.getQuestion().getQuestionId() == question.getQuestionId()) {
    				
    				QuestionOption questionOptionItem = new QuestionOption();
    			
    				questionOptionItem.setQuestionOptionId(questionOption.getQuestionOptionId());
    				questionOptionItem.setQuestionOption(questionOption.getQuestionOption());
    				
    				questionOptions.add(questionOptionItem);
    				
    			}
    			
    		}
    		
    		questionSumItem.setQuestionOptions(questionOptions);
    		
    		questionSum.add(questionSumItem);
   		
    	}
    	
        return questionSum;
    }
    
    
    /**
     *  RESTful service to get a question WITH OPTIONS by id
     * @param questionId
     * @return
     */
    @JsonView(View.QuestionRestFilter.class)
    @GetMapping("/questions/{id}")
    public @ResponseBody QuestionSum findQuestionWithOptionsRest(@PathVariable("id") Long questionId ) {
    	
    	Optional<Question> question = questionRepository.findById(questionId);
    	Iterable <QuestionOption> questionOptionsAll = questionOptionRepository.findAll();
    	
    	QuestionSum questionSumItem = new QuestionSum();
		
		// private long questionSumId;
		questionSumItem.setQuestionId(question.get().getQuestionId());
		
		//private String questionSumContent;
		questionSumItem.setQuestionContent(question.get().getQuestionContent());

		//private boolean questionOptionExist;
		questionSumItem.setQuestionOptionExist(question.get().isQuestionOptionExist());
		
		//private QuestionType questionType;
		questionSumItem.setQuestionType(question.get().getQuestionType());
		
		//private Survey survey;
		questionSumItem.setSurvey(question.get().getSurvey());
		
		//private List<QuestionOption> questionOptions;
		
		List<QuestionOption> questionOptions = new ArrayList<> ();
		
		for (QuestionOption questionOption : questionOptionsAll) {
			    			
			if (questionOption.getQuestion().getQuestionId() == question.get().getQuestionId()) {
				
				QuestionOption questionOptionItem = new QuestionOption();
			
				questionOptionItem.setQuestionOptionId(questionOption.getQuestionOptionId());
				questionOptionItem.setQuestionOption(questionOption.getQuestionOption());
				
				questionOptions.add(questionOptionItem);
				
			}
			
		}
		
		questionSumItem.setQuestionOptions(questionOptions);
		
    	return questionSumItem;
        
    }
    
    
    
    /**
     *  RESTful service to get all questions WITHOUT OPTIONS from database
     * @return
     */
   @GetMapping("/questions-no-options")
    public @ResponseBody List<Question> questionRest() {
    	
        return (List<Question>) questionRepository.findAll();
    }
    
    
    /**
     *  RESTful service to get a question WITHOUT OPTIONS by id
     * @param questionId
     * @return
     */
    @GetMapping("/questions-no-options/{id}")
    public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long questionId ) {
        
        return questionRepository.findById(questionId);
        
    }
    
    /**
     * Add question -> createSurvey HTML page
     * @param model
     * @return
     */
    @RequestMapping(value="/addquestion")
    public String addQuestion(Model model) {
    		model.addAttribute("question", new Question());
    		model.addAttribute("questionTypes", questionTypeRepository.findAll());
    		model.addAttribute("surveys", surveyRepository.findAll());
 
    		return "createSurvey";
    }
    
	/**
	 * Save a new question from HTML page
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveQuestionHtml(Question question) {
		//System.out.println("question.content: "+question.getQuestionContent()+ " question.id: "+question.getQuestionId());
		questionRepository.save(question);
		return "login";
	}

    
    /**
     *  RESTful service to SAVE a question
     * @param question
     * @return
     */
    @PostMapping("/questions")
    @ResponseBody
    public Question saveQuestion(@RequestBody Question question) {
    	
    	questionRepository.save(question);
    	
        return question;
    }
    
 
    /**
     *  RESTful service to get all questionoptions
     * @return
     */
    @JsonView(View.QuestionOptionRestFilter.class)
    @GetMapping("/questionoptions")
    public @ResponseBody Iterable<QuestionOption> questionOptionListRest() {
    	    
        return questionOptionRepository.findAll();
    }
    
    /**
     *  RESTful service to save questionoptions
     * @param questionOptionList
     * @return
     */
    @PostMapping("/questionoptions")
    @ResponseBody
    public List<QuestionOption> saveQuestionOptionList(@RequestBody List<QuestionOption> questionOptionList) {
    	
    	for (QuestionOption questionOptionItem : questionOptionList) {
			
    		questionOptionRepository.save(questionOptionItem);
				
		}
    
        return questionOptionList;
    }
}