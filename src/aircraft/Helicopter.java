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
      System.out.printf("%s#%s(%d): it's foggy!", "Helicopter%n", name, id);
      coordinates.modifyLongitudeBy(1);
    } else if (currentWeather == "rain") {
      System.out.printf("%s#%s(%d): it's raining!", "Helicopter%n", name, id);
      coordinates.modifyLongitudeBy(5);
    } else if (currentWeather == "snow") {
      System.out.printf("%s#%s(%d): it's snowing!", "Helicopter%n", name, id);
      coordinates.modifyHeightBy(-12);
    } else {
      System.out.printf("%s#%s(%d): it's sunny!", "Helicopter%n", name, id);
      coordinates.modifyLongitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
