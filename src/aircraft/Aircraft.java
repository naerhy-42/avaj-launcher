package aircraft;

import coordinates.Coordinates;

public class Aircraft extends Flyable {
  protected long id;
  protected String name;
  protected Coordinates coordinates;

  protected Aircraft(long id, String name, Coordinates coordinates) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
  }

  @Override
  public String getIdentity() {
    return String.format("%s#%s(%d)", getClass().getSimpleName(), name, id);
  }

  @Override
  public void updateConditions() {
    if (coordinates.getHeight() == 0) {
      System.out.printf("%s: I am landing!%n", getIdentity());
      weatherTower.unregister(this);
    }
  }
}
