package mit.ibook.btech.mit.controller.base;

import mit.ibook.btech.mit.dto.base.*;

public interface Operations
        <
                GET_RP extends Response, GET_RQ extends Request,
                UPDATE_RP extends Response, UPDATE_RQ extends Request,
                SEARCH_RP extends ListResponse, SEARCH_RQ extends PageableSearch,
                DELETE_RP extends Response, DELETE_RQ extends Request,
                CREATE_RP extends Response, CREATE_RQ extends Request,
                ALL_RP extends ListResponse, ALL_RQ extends PageableSearch> {
    AbstractResponse<GET_RP> get(GET_RQ request);

    AbstractResponse<ALL_RP> getALL(ALL_RQ getAll);

    AbstractResponse<DELETE_RP> delete(DELETE_RQ delete);

    AbstractResponse<UPDATE_RP> update(UPDATE_RQ update);

    AbstractResponse<CREATE_RP> create(CREATE_RQ create);

    AbstractResponse<SEARCH_RP> search(SEARCH_RQ search);
}
