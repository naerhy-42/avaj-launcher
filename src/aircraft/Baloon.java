package aircraft;

import coordinates.Coordinates;

public class Baloon extends Aircraft {
  public Baloon(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    if (currentWeather == "fog") {
      System.out.printf("%s: it's foggy!%n", getIdentity());
      coordinates.modifyHeightBy(-3);
    } else if (currentWeather == "rain") {
      System.out.printf("%s: it's raining!%n", getIdentity());
      coordinates.modifyHeightBy(-5);
    } else if (currentWeather == "snow") {
      System.out.printf("%s: it's snowing!%n", getIdentity());
      coordinates.modifyHeightBy(-15);
    } else {
      System.out.printf("%s: it's sunny!%n", getIdentity());
      coordinates.modifyLongitudeBy(2);
      coordinates.modifyHeightBy(4);
    }
    super.updateConditions();
  }
}
