package aircraft;

import coordinates.Coordinates;

public final class AircraftFactory {
  private static AircraftFactory instance; // default uninitialized value = null
  private long currentAircraftId = 0;

  public static AircraftFactory getInstance() {
    if (instance == null) {
      instance = new AircraftFactory();
    }
    return instance;
  }

  public Flyable newAircraft(String type, String name, Coordinates coordinates) {
    Flyable flyable;
    if (type == "Baloon") {
      flyable = new Baloon(currentAircraftId, name, coordinates);
    } else if (type == "Helicopter") {
      flyable = new Helicopter(currentAircraftId, name, coordinates);
    } else {
      flyable = new JetPlane(currentAircraftId, name, coordinates);
    }
    currentAircraftId++;
    return flyable;
  }
}
