package fr.anthonygodin.api.dto.Response;

/**
 * Created by AnthoGdn on 16/03/17.
 */
public class ErrorDTO {
    private String key;
    private String message;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
