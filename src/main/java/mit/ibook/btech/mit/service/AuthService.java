package mit.ibook.btech.mit.service;

import com.auth0.jwt.JWT;
import jdk.jfr.Label;
import lombok.RequiredArgsConstructor;
import mit.ibook.btech.mit.dto.auth.request.ALoginRQ;
import mit.ibook.btech.mit.dto.auth.response.ALoginRP;
import mit.ibook.btech.mit.entity.Users;
import mit.ibook.btech.mit.exceptions.RestException;
import mit.ibook.btech.mit.repository.AuthRepository;
import mit.ibook.btech.mit.utils.JWTUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("authService")
public class AuthService implements UserDetailsService {

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil util;

    public AuthService(AuthRepository authRepository, @Lazy AuthenticationManager authenticationManager, JWTUtil util) {
        this.authRepository = authRepository;
        this.authenticationManager = authenticationManager;
        this.util = util;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = authRepository.findByUsernameAndDeletedFalse(username);
        Users user = optionalUsers.orElseThrow(() -> {
            throw new RuntimeException("User Not Found");
        });
        return user;
    }


    public ALoginRP login(ALoginRQ login) {
        Users userByUsername;
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            userByUsername = (Users) authenticate.getPrincipal();
        } catch (Exception e) {
            throw new RestException("Authentication failed");
        }
        ALoginRP aLoginRP=new ALoginRP();
        aLoginRP.setAccessToken(accessToken(userByUsername.getClaimsByScope(login.getScope())));
        aLoginRP.setRefreshToken(refreshToken(login.getUsername()));
        aLoginRP.setExpiresIn(util.getExpireDate().getTime());
        aLoginRP.setRefreshTokenExpire(util.getExpireDateForRefreshToken().getTime());
        aLoginRP.setTokenType("Bearer");
        return aLoginRP;
    }

    private String accessToken(Map<String,String>claims) {
        String access = JWT.create().withIssuer(util.getIssuerAccess()).withSubject("access").withExpiresAt(util.getExpireDate()).withClaim("data",claims).sign(util.getAlgorithm());
        return access;
    }

    private String refreshToken(String username) {
        String refresh = JWT.create().withIssuer(util.getIssuerRefresh()).withSubject("refresh").withExpiresAt(util.getExpireDateForRefreshToken()).withClaim("username", username).sign(util.getAlgorithm());
        return refresh;
    }
}
