package exceptions;

public class InvalidArgumentsException extends Exception {
  public InvalidArgumentsException() {
    super("More or less than 1 argument has been provided to the program");
  }
}
