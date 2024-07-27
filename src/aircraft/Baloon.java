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
      fileHandler.addToOutput(String.format("%s: foggy conditions, staying in close communication.", getIdentity()));
      coordinates.modifyHeightBy(-3);
    } else if (currentWeather == "rain") {
      fileHandler.addToOutput(String.format("%s: flying through a rain shower, but the balloon is handling it fine.", getIdentity()));
      coordinates.modifyHeightBy(-5);
    } else if (currentWeather == "snow") {
      fileHandler.addToOutput(String.format("%s: descending through snow.", getIdentity()));
      coordinates.modifyHeightBy(-15);
    } else {
      fileHandler.addToOutput(String.format("%s: beautiful weather for a smooth ascent.", getIdentity()));
      coordinates.modifyLongitudeBy(2);
      coordinates.modifyHeightBy(4);
    }
    super.updateConditions();
  }
}
