package mit.ibook.btech.mit.repository;

import mit.ibook.btech.mit.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole,Long> {
}
