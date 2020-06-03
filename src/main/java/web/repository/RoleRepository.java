package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);


}
