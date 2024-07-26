package exceptions;

public class InvalidArgumentsException extends Exception {
  public InvalidArgumentsException() {
    super("More or less than 1 argument has been provided to the program");
  }

  public InvalidArgumentsException(String message) {
    super(message);
  }

  public InvalidArgumentsException(Throwable cause) {
    super(cause);
  }

  public InvalidArgumentsException(String message, Throwable cause) {
    super(message, cause);
  }
}
