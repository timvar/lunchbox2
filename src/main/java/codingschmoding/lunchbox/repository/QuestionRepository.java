package codingschmoding.lunchbox.repository;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
