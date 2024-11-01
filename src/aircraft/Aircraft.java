package aircraft;

import coordinates.Coordinates;
import file.FileHandler;

public class Aircraft extends Flyable {
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  protected FileHandler fileHandler;

  protected Aircraft(long id, String name, Coordinates coordinates) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    fileHandler = FileHandler.getInstance();
  }

  @Override
  public String getIdentity() {
    return String.format("%s#%s(%d)", getClass().getSimpleName(), name, id);
  }

  @Override
  public void updateConditions() {
    if (coordinates.getHeight() == 0) {
      fileHandler.addToOutput(String.format("%s: I am landing!", getIdentity()));
      weatherTower.unregister(this);
    }
  }
}
