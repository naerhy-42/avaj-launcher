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
      fileHandler.addToOutput(String.format("%s: flying through fog, maintaining safety.", getIdentity()));
      coordinates.modifyLongitudeBy(1);
    } else if (currentWeather == "rain") {
      fileHandler.addToOutput(String.format("%s: we're encountering some rain but it's manageable.", getIdentity()));
      coordinates.modifyLongitudeBy(5);
    } else if (currentWeather == "snow") {
      fileHandler.addToOutput(String.format("%s: light snow along our route.", getIdentity()));
      coordinates.modifyHeightBy(-12);
    } else {
      fileHandler.addToOutput(String.format("%s: sunny weather, smooth flight ahead.", getIdentity()));
      coordinates.modifyLongitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
