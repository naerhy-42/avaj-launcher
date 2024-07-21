package aircraft;

import coordinates.Coordinates;

public class JetPlane extends Aircraft {
  public JetPlane(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    if (currentWeather == "fog") {
      System.out.printf("%s#%s(%d): it's foggy!%n", "JetPlane", name, id);
      coordinates.modifyLatitudeBy(1);
    } else if (currentWeather == "rain") {
      System.out.printf("%s#%s(%d): it's raining!%n", "JetPlane", name, id);
      coordinates.modifyLatitudeBy(5);
    } else if (currentWeather == "snow") {
      System.out.printf("%s#%s(%d): it's snowing!%n", "JetPlane", name, id);
      coordinates.modifyHeightBy(-7);
    } else {
      System.out.printf("%s#%s(%d): it's sunny!%n", "JetPlane", name, id);
      coordinates.modifyLatitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
