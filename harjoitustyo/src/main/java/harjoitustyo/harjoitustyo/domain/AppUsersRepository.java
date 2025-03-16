package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUsers, Long> {
	AppUsers findByUsername(String username);
}