package fr.anthonygodin.api.dto.response;

import java.util.List;

/**
 * Created by AnthoGdn on 16/03/17.
 */
public class ErrorResponseDTO implements ResponseDTO {

    private List<ErrorDTO> errors;

    public List<ErrorDTO> getErrors() {
        return errors;
    }
    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
