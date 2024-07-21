package aircraft;

import coordinates.Coordinates;
import file.FileHandler;

public class Baloon extends Aircraft {
  public Baloon(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    if (currentWeather == "fog") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's foggy!", getIdentity()));
      coordinates.modifyHeightBy(-3);
    } else if (currentWeather == "rain") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's raining!", getIdentity()));
      coordinates.modifyHeightBy(-5);
    } else if (currentWeather == "snow") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's snowing!", getIdentity()));
      coordinates.modifyHeightBy(-15);
    } else {
      FileHandler.getInstance().addToOutput(String.format("%s: it's sunny!", getIdentity()));
      coordinates.modifyLongitudeBy(2);
      coordinates.modifyHeightBy(4);
    }
    super.updateConditions();
  }
}
