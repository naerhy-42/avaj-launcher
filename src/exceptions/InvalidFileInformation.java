package exceptions;

public class InvalidFileInformation extends Exception {
  public InvalidFileInformation() {
    super("One of the information contained in the scenario file is not valid");
  }

  public InvalidFileInformation(String message) {
    super(message);
  }

  public InvalidFileInformation(Throwable cause) {
    super(cause);
  }

  public InvalidFileInformation(String message, Throwable cause) {
    super(message, cause);
  }
}
