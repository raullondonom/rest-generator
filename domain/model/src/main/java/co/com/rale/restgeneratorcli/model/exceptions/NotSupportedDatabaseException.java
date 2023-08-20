package co.com.rale.restgeneratorcli.model.exceptions;

public class NotSupportedDatabaseException extends Exception {

  public NotSupportedDatabaseException(Throwable cause, String message) {
    super(message, cause);
  }

  public NotSupportedDatabaseException(String message) {
    super(message);
  }

  public NotSupportedDatabaseException(Throwable cause) {
    super(cause);
  }
}
