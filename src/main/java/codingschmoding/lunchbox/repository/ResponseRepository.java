package codingschmoding.lunchbox.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.Response;

public interface ResponseRepository extends CrudRepository <Response, Long> {
	

	List<Response> findByResponse(String response);

}