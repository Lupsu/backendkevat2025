package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    Roles findByRoleName(String roleName);
}
