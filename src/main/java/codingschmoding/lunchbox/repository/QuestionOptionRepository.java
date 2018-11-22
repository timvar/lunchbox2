package codingschmoding.lunchbox.repository;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.QuestionOption;

public interface QuestionOptionRepository extends  CrudRepository<QuestionOption, Long> {

}
