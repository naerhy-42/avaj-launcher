package aircraft;

import coordinates.Coordinates;

public final class AircraftFactory {
  private static AircraftFactory instance;
  private long currentAircraftId = 0;

  public static AircraftFactory getInstance() {
    if (instance == null) {
      instance = new AircraftFactory();
    }
    return instance;
  }

  public Flyable newAircraft(String type, String name, Coordinates coordinates) {
    Flyable flyable;
    if (type.equals("Balloon")) {
      flyable = new Balloon(currentAircraftId, name, coordinates);
    } else if (type.equals("Helicopter")) {
      flyable = new Helicopter(currentAircraftId, name, coordinates);
    } else {
      flyable = new JetPlane(currentAircraftId, name, coordinates);
    }
    currentAircraftId++;
    return flyable;
  }
}
