package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepository extends CrudRepository<AppUsers, Long> {
	AppUsers findByUsername(String username);
}