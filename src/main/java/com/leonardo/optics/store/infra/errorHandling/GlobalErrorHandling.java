package com.leonardo.optics.store.infra.errorHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandling {

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorHandling.class);

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public static class NoContentException extends RuntimeException {
        public NoContentException() {
            super();
        }
    }

    public static class DataIntegrityViolationException extends RuntimeException {
        public DataIntegrityViolationException() {
            super();
        }
    }

    public static class PasswordNotMatchesException extends RuntimeException {
        public PasswordNotMatchesException() {
            super();
        }
    }

    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> error201() {
        log.error("NO_CONTENT: No Content!?.");
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> Error404(ResourceNotFoundException exception) {
        log.error("NOT_FOUND: Not found!? {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> Error400(HttpMessageNotReadableException ex) {
        log.error("BAD_REQUEST: Body request is invalid or empty.");
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // @ExceptionHandler(BadCredentialsException.class)
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // public ResponseEntity<String> ErrorBadCredentials() {
    //     log.error("UNAUTHORIZED: Invalid credentials.");
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    // }

    // @ExceptionHandler(AuthenticationException.class)
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // public ResponseEntity<String> ErrorAuthentication() {
    //     log.error("UNAUTHORIZED: Auth failed");
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Auth failed");
    // }

    // @ExceptionHandler(AccessDeniedException.class)
    // @ResponseStatus(HttpStatus.FORBIDDEN)
    // public ResponseEntity<String> AccessDenied() {
    //     log.error("FORBIDDEN: Access denied");
    //     return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
    // }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> error500(Exception exception) {
        log.error("INTERNAL_SERVER_ERROR: {}", exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + exception.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        String ErrorMessage = "An error occurred while processing your request, The provided value already exists in the database.";
        log.error("CONFLICT: {}", ErrorMessage);
        return new ResponseEntity<>("409", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PasswordNotMatchesException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> PasswordNotMatchesException(PasswordNotMatchesException exception) {
        String ErrorMessage = "Passwords not matches or Passwords is invalid";
        log.error("BAD_REQUEST: {}", ErrorMessage);
        return new ResponseEntity<>(ErrorMessage, HttpStatus.UNAUTHORIZED);
    }

    // @ExceptionHandler(InternalAuthenticationServiceException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // public ResponseEntity<String> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException exception) {
    //     String ErrorMessage = "An error occurred while authenticating the user, Please try again later";
    //     log.error("INTERNAL_SERVER_ERROR: {}", ErrorMessage);
    //     return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
}
