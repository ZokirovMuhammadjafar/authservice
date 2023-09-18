package mit.ibook.btech.mit.dto.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AbstractResponse<T extends Response> implements Response {

    private T data;
    private RestError restError;
    private Integer code;
    private boolean success;
    private String className;

    public static <K extends Response & Serializable> AbstractResponse<K> of(K data) {
        AbstractResponse<K> abstractResponse = new AbstractResponse<>(200, true);
        abstractResponse.setData(data);
        abstractResponse.setClassName(data.getClass().getSimpleName());
        return abstractResponse;
    }

    public AbstractResponse(Integer code, boolean success) {
        this.code = code;
        this.success = success;
    }

    public AbstractResponse() {
    }
}
