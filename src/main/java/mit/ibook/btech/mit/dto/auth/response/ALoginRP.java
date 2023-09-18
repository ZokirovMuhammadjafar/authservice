package mit.ibook.btech.mit.dto.auth.response;

import lombok.Getter;
import lombok.Setter;
import mit.ibook.btech.mit.dto.base.Response;
@Setter
@Getter
public class ALoginRP implements Response {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long refreshTokenExpire;
    private Long expiresIn;
}
