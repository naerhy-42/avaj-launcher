package aircraft;

import coordinates.Coordinates;

public class Helicopter extends Aircraft {
  public Helicopter(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    if (currentWeather == "fog") {
      System.out.printf("%s: it's foggy!%n", getIdentity());
      coordinates.modifyLongitudeBy(1);
    } else if (currentWeather == "rain") {
      System.out.printf("%s: it's raining!%n", getIdentity());
      coordinates.modifyLongitudeBy(5);
    } else if (currentWeather == "snow") {
      System.out.printf("%s: it's snowing!%n", getIdentity());
      coordinates.modifyHeightBy(-12);
    } else {
      System.out.printf("%s: it's sunny!%n", getIdentity());
      coordinates.modifyLongitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
