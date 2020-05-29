package py.com.poraplz.cursomc.config.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import py.com.poraplz.cursomc.dto.StandartError;
import py.com.poraplz.cursomc.dto.ValidationError;
import py.com.poraplz.cursomc.rest.controllers.auth.AuthorizationException;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.BrokenDataIntegrity;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFound e, HttpServletRequest request){
        StandartError sdtError = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sdtError);
    }

    @ExceptionHandler(BrokenDataIntegrity.class)
    public ResponseEntity<StandartError> constraintViolationException(BrokenDataIntegrity e, HttpServletRequest request){
        StandartError standartError = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> argumentValidation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Error de validacion",
                System.currentTimeMillis());
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            validationError.addError(x.getField(), x.getDefaultMessage());
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);

    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandartError> authorizationException(AuthorizationException e, HttpServletRequest request){
        StandartError sdtError = new StandartError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(sdtError);
    }



}
