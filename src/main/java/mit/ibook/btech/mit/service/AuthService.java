package mit.ibook.btech.mit.service;

import lombok.RequiredArgsConstructor;
import mit.ibook.btech.mit.dto.auth.request.ALoginRQ;
import mit.ibook.btech.mit.dto.auth.response.ALoginRP;
import mit.ibook.btech.mit.entity.Users;
import mit.ibook.btech.mit.repository.AuthRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("authService")
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = authRepository.findByUsernameAndDeletedFalse(username);
        Users user = optionalUsers.orElseThrow(() -> {
            throw new RuntimeException("User Not Found");
        });
        return  user;
    }


    public ALoginRP login(ALoginRQ login) {
        UserDetails userDetails = loadUserByUsername(login.getUsername());

        return null;
    }
}
