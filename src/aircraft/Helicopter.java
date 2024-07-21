package aircraft;

import coordinates.Coordinates;
import file.FileHandler;

public class Helicopter extends Aircraft {
  public Helicopter(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    if (currentWeather == "fog") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's foggy!", getIdentity()));
      coordinates.modifyLongitudeBy(1);
    } else if (currentWeather == "rain") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's raining!", getIdentity()));
      coordinates.modifyLongitudeBy(5);
    } else if (currentWeather == "snow") {
      FileHandler.getInstance().addToOutput(String.format("%s: it's snowing!", getIdentity()));
      coordinates.modifyHeightBy(-12);
    } else {
      FileHandler.getInstance().addToOutput(String.format("%s: it's sunny!", getIdentity()));
      coordinates.modifyLongitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
