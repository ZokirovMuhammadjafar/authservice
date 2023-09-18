package mit.ibook.btech.mit.controller;

import mit.ibook.btech.mit.dto.auth.request.*;
import mit.ibook.btech.mit.dto.auth.response.*;
import mit.ibook.btech.mit.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends AbstractController<AuthService,
        AGetRP,AGetRQ,
        AUpdateRP, AUpdateRQ,
        ASearchRP, ASearchRQ,
        ADeleteRP, ADeleteRQ,
        ACreateRP, ACreateRQ,
        AGetAllRP, AGetAllRQ
        >{


    protected AuthController(AuthService abstractService) {
        super(abstractService);
    }

    @Override
    public AGetRP get(AGetRQ request) {
        return null;
    }

    @Override
    public AGetAllRP getALL(AGetAllRQ getAll) {
        return null;
    }

    @Override
    public ADeleteRP delete(ADeleteRQ delete) {
        return null;
    }

    @Override
    public AUpdateRP update(AUpdateRQ update) {
        return null;
    }

    @Override
    public ACreateRP create(ACreateRQ create) {
        return null;
    }

    @Override
    public ASearchRP search(ASearchRQ search) {
        return null;
    }

    @PostMapping("/login")
    public ALoginRP login(ALoginRQ login){
        return abstractService.login(login);
    }


}
