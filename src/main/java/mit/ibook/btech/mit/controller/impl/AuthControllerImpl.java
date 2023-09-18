package mit.ibook.btech.mit.controller.impl;

import mit.ibook.btech.mit.controller.base.AbstractController;
import mit.ibook.btech.mit.controller.AuthController;
import mit.ibook.btech.mit.dto.auth.request.*;
import mit.ibook.btech.mit.dto.auth.response.*;
import mit.ibook.btech.mit.dto.base.AbstractResponse;
import mit.ibook.btech.mit.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl extends AbstractController<AuthService> implements AuthController {
    protected AuthControllerImpl(AuthService abstractService) {
        super(abstractService, AuthController.class);
    }


    @Override

    public AbstractResponse<ALoginRP> login(ALoginRQ login) {
        ALoginRP response = abstractService.login(login);
        return AbstractResponse.of(response);
    }

    @Override
    public AbstractResponse<AGetRP> get(AGetRQ request) {
        return null;
    }

    @Override
    public AbstractResponse<AGetAllRP> getALL(AGetAllRQ getAll) {
        return null;
    }

    @Override
    public AbstractResponse<ADeleteRP> delete(ADeleteRQ delete) {
        return null;
    }

    @Override
    public AbstractResponse<AUpdateRP> update(AUpdateRQ update) {
        return null;
    }

    @Override
    public AbstractResponse<ACreateRP> create(ACreateRQ create) {
        return null;
    }

    @Override
    public AbstractResponse<ASearchRP> search(ASearchRQ search) {
        return null;
    }
}
