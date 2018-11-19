package codingschmoding.lunchbox.repository;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.QuestionType;

public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {
	
}
