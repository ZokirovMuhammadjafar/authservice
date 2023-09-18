package mit.ibook.btech.mit.controller;

import mit.ibook.btech.mit.dto.base.ListResponse;
import mit.ibook.btech.mit.dto.base.PageableSearch;
import mit.ibook.btech.mit.dto.base.Request;
import mit.ibook.btech.mit.dto.base.Response;

public abstract class AbstractController<T,
        GET_RP extends Response ,GET_RQ extends Request,
        UPDATE_RP extends Response ,UPDATE_RQ extends Request,
        SEARCH_RP extends ListResponse,SEARCH_RQ extends PageableSearch,
        DELETE_RP extends Response ,DELETE_RQ extends Request,
        CREATE_RP extends Response ,CREATE_RQ extends Request,
       ALL_RP extends ListResponse ,ALL_RQ extends PageableSearch> {

    protected final T abstractService;

    protected AbstractController(T abstractService) {
        this.abstractService = abstractService;
    }

    public abstract GET_RP get(GET_RQ request);
    public abstract ALL_RP getALL(ALL_RQ getAll);
    public abstract DELETE_RP delete(DELETE_RQ delete);
    public abstract UPDATE_RP update(UPDATE_RQ update);
    public abstract CREATE_RP create(CREATE_RQ create);
    public abstract SEARCH_RP search(SEARCH_RQ search);
}
