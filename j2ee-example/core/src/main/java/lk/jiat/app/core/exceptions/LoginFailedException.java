package lk.jiat.app.core.exceptions;

public class LoginFailedException  extends RuntimeException{
    public LoginFailedException(String message) {
        super(message);
    }
}
