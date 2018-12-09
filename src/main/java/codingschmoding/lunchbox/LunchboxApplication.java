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
import codingschmoding.lunchbox.domain.QuestionOption;
import codingschmoding.lunchbox.domain.Survey;
import codingschmoding.lunchbox.domain.User;
import codingschmoding.lunchbox.repository.QuestionRepository;
import codingschmoding.lunchbox.repository.QuestionTypeRepository;
import codingschmoding.lunchbox.repository.QuestionOptionRepository;
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
	public CommandLineRunner demo(
			QuestionRepository questionRepository,
			ResponseRepository responseRepository,
			QuestionTypeRepository questionTypeRepository,
			QuestionOptionRepository questionOptionRepository,
			SurveyRepository surveyRepository, 
			UserRepository userRepository) {
		
		return (args) -> {
			log.info("save a question");
			
			User user1 = new User("netta");
			userRepository.save(user1);

			Survey survey = new Survey("tyytyvaisyyskysely", user1);
			
			surveyRepository.save(survey);
			
			QuestionType questionTypeText = new QuestionType("text");
			QuestionType questionTypeRadio = new QuestionType("radio");
			QuestionType questionTypeCheck = new QuestionType("checkbox");
			//QuestionType questionTypeNumber = new QuestionType("number"); ** number not needed
			//QuestionType questionTypeRadiobutton = new QuestionType("radiobutton");
			
			questionTypeRepository.save(questionTypeText);
			questionTypeRepository.save(questionTypeRadio);
			questionTypeRepository.save(questionTypeCheck);
			//questionTypeRepository.save(questionTypeNumber);

			Question question1 = new Question("Kerro, mitä mieltä olet?", questionTypeText, false, survey);
			Question question3 = new Question("Valitse alla olevista vaihtoehdoista mieleisesi", questionTypeCheck, true, survey);
			// Question question4 = new Question("Monestiko viikossa käytät palveluita?", questionTypeNumber, false, survey);
			Question question5 = new Question("Oletko tyytyväinen saamaasi palveluun?", questionTypeRadio, true, survey);
			
			questionRepository.save(question1);
			questionRepository.save(question3);
			// questionRepository.save(question4); ** number - not needed
			questionRepository.save(question5);
			
			Response response1 = new Response("vastaus1", question1);
			responseRepository.save(response1);
			
			QuestionOption questionOption1 = new QuestionOption("1-2", question3);
			QuestionOption questionOption2 = new QuestionOption("3-4", question3);
			QuestionOption questionOption3 = new QuestionOption("5-6", question3);
			
			questionOptionRepository.save(questionOption1);
			questionOptionRepository.save(questionOption2);
			questionOptionRepository.save(questionOption3);
			
			QuestionOption questionOption4 = new QuestionOption("En ikinä", question5);
			QuestionOption questionOption5 = new QuestionOption("Joskus harvoin", question5);
			QuestionOption questionOption6 = new QuestionOption("Joka kuukausi pari kertaa", question5);
			QuestionOption questionOption7 = new QuestionOption("Viikoittain", question5);
			QuestionOption questionOption8 = new QuestionOption("Joka päivä!!", question5);
			
			questionOptionRepository.save(questionOption4);
			questionOptionRepository.save(questionOption5);
			questionOptionRepository.save(questionOption6);
			questionOptionRepository.save(questionOption7);
			questionOptionRepository.save(questionOption8);
		};
	}
}

