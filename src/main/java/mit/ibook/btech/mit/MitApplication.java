package mit.ibook.btech.mit;

import lombok.RequiredArgsConstructor;
import mit.ibook.btech.mit.entity.UserRole;
import mit.ibook.btech.mit.entity.Users;
import mit.ibook.btech.mit.repository.AuthRepository;
import mit.ibook.btech.mit.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MitApplication implements CommandLineRunner {

    private final PasswordEncoder encoder;
    private final AuthRepository authRepository;
    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MitApplication.class, args);

    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        UserRole userRole=new UserRole();
//        userRole.setCode("ADMIN");
//        userRole.setName("admin");
//        userRole.setPermissions(List.of("ADMIN"));
//        Users users=new Users();
//        users.setActived(true);
//        users.setEmail("ibook@gmail.com");
//        users.setFirstName("Muhammadjafar");
//        users.setLastName("Zokirov");
//        users.setMiddleName("Mutalib");
//        users.setPhone("998946753336");
//        users.setRegionId(1L);
//        users.setUserRoles(List.of(roleRepository.save(userRole)));
//        users.setPassword(encoder.encode("123456"));
//        users.setUsername("admin");
//        authRepository.save(users);
//
//        System.out.println(this.encoder.encode("123456"));
    }
}
