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
      fileHandler.addToOutput(String.format("%s: it's foggy!", getIdentity()));
      coordinates.modifyLatitudeBy(1);
    } else if (currentWeather == "rain") {
      fileHandler.addToOutput(String.format("%s: it's raining!", getIdentity()));
      coordinates.modifyLatitudeBy(5);
    } else if (currentWeather == "snow") {
      fileHandler.addToOutput(String.format("%s: it's snowing!", getIdentity()));
      coordinates.modifyHeightBy(-7);
    } else {
      fileHandler.addToOutput(String.format("%s: it's sunny!", getIdentity()));
      coordinates.modifyLatitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
