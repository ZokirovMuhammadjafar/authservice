package mit.ibook.btech.mit.dto.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
public class AbstractResponse<T extends Response> {
    private T data;
    private RestError restError;
    private Integer code;
    private boolean success;
    private String className;

    public static <K extends Response> AbstractResponse<K> of(K data) {
        AbstractResponse<K> abstractResponse = new AbstractResponse<>(200, true);
        abstractResponse.setData(data);
        abstractResponse.setClassName(data.getClass().getSimpleName());
        return abstractResponse;
    }

    public AbstractResponse(Integer code, boolean success) {
        this.code = code;
        this.success = success;
    }
}
