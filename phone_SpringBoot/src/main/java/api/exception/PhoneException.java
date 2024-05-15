package api.exception;

public class PhoneException extends RuntimeException {

    public PhoneException(Long id) {
        super("Phone not found with id: " + id);
    }

    public PhoneException(String message) {
        super(message);
    }
}