package py.com.poraplz.cursomc.rest.controllers.auth;

import java.io.Serializable;

public class AuthorizationException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 1L;

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
