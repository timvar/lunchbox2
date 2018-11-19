package codingschmoding.lunchbox.repository;

import org.springframework.data.repository.CrudRepository;

import codingschmoding.lunchbox.domain.User;

public interface UserRepository extends CrudRepository <User, Long> {

}
