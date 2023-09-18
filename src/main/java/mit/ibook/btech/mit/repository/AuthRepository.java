package mit.ibook.btech.mit.repository;

import lombok.NonNull;
import mit.ibook.btech.mit.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsernameAndDeletedFalse(@NonNull String username);

}
