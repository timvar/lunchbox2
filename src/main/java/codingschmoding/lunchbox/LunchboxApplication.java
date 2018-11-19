package codingschmoding.lunchbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import codingschmoding.lunchbox.domain.Question;
import codingschmoding.lunchbox.domain.QuestionType;
import codingschmoding.lunchbox.domain.Response;
import codingschmoding.lunchbox.domain.Survey;
import codingschmoding.lunchbox.domain.User;
import codingschmoding.lunchbox.repository.QuestionRepository;
import codingschmoding.lunchbox.repository.QuestionTypeRepository;
import codingschmoding.lunchbox.repository.ResponseRepository;
import codingschmoding.lunchbox.repository.SurveyRepository;
import codingschmoding.lunchbox.repository.UserRepository;

@SpringBootApplication
public class LunchboxApplication {
	private static final Logger log = LoggerFactory.getLogger(LunchboxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LunchboxApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(QuestionRepository questionRepository,
			ResponseRepository responseRepository,
			QuestionTypeRepository questionTypeRepository,
			SurveyRepository surveyRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a question");
			
			User user = new User("Netta");
			
			userRepository.save(user);
			
			Survey survey = new Survey("tyytyvaisyyskysely", user);
			
			surveyRepository.save(survey);
			
			QuestionType questionTypeText = new QuestionType("text");
			//QuestionType questionTypeRadiobutton = new QuestionType("radiobutton");
			
			questionTypeRepository.save(questionTypeText);

			Question question1 = new Question("eka?", questionTypeText, survey);
			questionRepository.save(question1);
			Response response1 = new Response("vastaus1", question1);
			responseRepository.save(response1);
			
			
			/*Response response2 = new Response("vastaus2", question1);
			responseRepository.save(response2);
			Question question2 = new Question("toka?", "text");
			Question question3 = new Question("kolmas?", "text");
			Question question4 = new Question("neljäs?", "text");
			Question question5 = new Question("viides?", "text");*/
			
			
			/*questionRepository.save(question2);
			questionRepository.save(question3);
			questionRepository.save(question4);
			questionRepository.save(question5);*/
			

		};
	}
}

