package mit.ibook.btech.mit.dto.auth.request;

import lombok.Getter;
import lombok.Setter;
import mit.ibook.btech.mit.dto.base.Request;

@Getter
@Setter
public class ALoginRQ implements Request {
    private String username;
    private String password;
}
