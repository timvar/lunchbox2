package codingschmoding.lunchbox.repository;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Long>  {

}
