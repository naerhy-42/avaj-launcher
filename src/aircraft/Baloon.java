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
      fileHandler.addToOutput(String.format("%s: it's foggy!", getIdentity()));
      coordinates.modifyHeightBy(-3);
    } else if (currentWeather == "rain") {
      fileHandler.addToOutput(String.format("%s: it's raining!", getIdentity()));
      coordinates.modifyHeightBy(-5);
    } else if (currentWeather == "snow") {
      fileHandler.addToOutput(String.format("%s: it's snowing!", getIdentity()));
      coordinates.modifyHeightBy(-15);
    } else {
      fileHandler.addToOutput(String.format("%s: it's sunny!", getIdentity()));
      coordinates.modifyLongitudeBy(2);
      coordinates.modifyHeightBy(4);
    }
    super.updateConditions();
  }
}
