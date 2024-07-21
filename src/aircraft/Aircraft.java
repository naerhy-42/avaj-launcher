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
  public long getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void updateConditions() {
    if (coordinates.getHeight() == 0) {
      System.out.printf("%s#%s(%d): I am landing!%n", getClass().getSimpleName(), name, id);
      weatherTower.unregister(this);
    }
  }
}
