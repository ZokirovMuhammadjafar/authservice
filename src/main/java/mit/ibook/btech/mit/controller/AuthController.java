package mit.ibook.btech.mit.controller;

import mit.ibook.btech.mit.controller.base.Operations;
import mit.ibook.btech.mit.dto.auth.request.*;
import mit.ibook.btech.mit.dto.auth.response.*;
import mit.ibook.btech.mit.dto.base.AbstractResponse;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/auth")
public interface AuthController extends Operations<AGetRP, AGetRQ,
        AUpdateRP, AUpdateRQ,
        ASearchRP, ASearchRQ,
        ADeleteRP, ADeleteRQ,
        ACreateRP, ACreateRQ,
        AGetAllRP, AGetAllRQ
        > {
    @PostMapping("/login")
    @ResponseBody
    AbstractResponse<ALoginRP> login(@RequestBody ALoginRQ login);

    @Override
    AbstractResponse<AGetRP> get(AGetRQ request);

    @Override
    AbstractResponse<AGetAllRP> getALL(AGetAllRQ getAll);

    @Override
    AbstractResponse<ADeleteRP> delete(ADeleteRQ delete);

    @Override
    AbstractResponse<AUpdateRP> update(AUpdateRQ update);

    @Override
    AbstractResponse<ACreateRP> create(ACreateRQ create);

    @Override
    AbstractResponse<ASearchRP> search(ASearchRQ search);


}
