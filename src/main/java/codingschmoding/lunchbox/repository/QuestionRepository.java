package codingschmoding.lunchbox.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findByQuestionContent(String questionContent);

}
