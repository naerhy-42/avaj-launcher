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
      System.out.printf("%s#%s(%d): it's foggy!", "Baloon%n", name, id);
      coordinates.modifyHeightBy(-3);
    } else if (currentWeather == "rain") {
      System.out.printf("%s#%s(%d): it's raining!", "Baloon%n", name, id);
      coordinates.modifyHeightBy(-5);
    } else if (currentWeather == "snow") {
      System.out.printf("%s#%s(%d): it's snowing!", "Baloon%n", name, id);
      coordinates.modifyHeightBy(-15);
    } else {
      System.out.printf("%s#%s(%d): it's sunny!", "Baloon%n", name, id);
      coordinates.modifyLongitudeBy(2);
      coordinates.modifyHeightBy(4);
    }
    super.updateConditions();
  }
}
