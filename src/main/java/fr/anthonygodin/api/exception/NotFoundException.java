package fr.anthonygodin.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AnthoGdn on 17/03/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception implements RestException {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

    public NotFoundException(String id, String entityName) {
        super(entityName + " entity with " + id + " id is not found");
        LOGGER.info("{} entity with {} id is not found",entityName, id);
    }
}
