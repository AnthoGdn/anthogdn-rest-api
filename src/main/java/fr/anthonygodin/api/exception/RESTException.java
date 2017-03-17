package fr.anthonygodin.api.exception;

import fr.anthonygodin.api.domain.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnthoGdn on 17/03/17.
 */
public class RESTException extends Exception {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

    private final Error error;

    public RESTException(Error error, String id) {
        super(error.getMessage());
        this.error = error;
        LOGGER.info("{} with {} id is not found", error.getEntityName().getName(), id);
    }

    public Error getError() {
        return error;
    }
}
