package lucas.ifmg.produtos.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException() {}

    public DatabaseException(String message) {
        super(message);
    }
}