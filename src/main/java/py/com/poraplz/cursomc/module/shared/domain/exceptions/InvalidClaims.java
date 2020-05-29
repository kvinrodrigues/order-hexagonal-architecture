package py.com.poraplz.cursomc.module.shared.domain.exceptions;

public class InvalidClaims extends RuntimeException{
    private static final long serialVersionUID=1L;

    public InvalidClaims(String message) {
        super(message);
    }

    public InvalidClaims(String message, Throwable cause) {
        super(message, cause);
    }
}
