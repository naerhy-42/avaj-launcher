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
      fileHandler.addToOutput(String.format("%s: flying through foggy areas.", getIdentity()));
      coordinates.modifyLatitudeBy(1);
    } else if (currentWeather == "rain") {
      fileHandler.addToOutput(String.format("%s: experiencing light rain now, everything's under control.", getIdentity()));
      coordinates.modifyLatitudeBy(5);
    } else if (currentWeather == "snow") {
      fileHandler.addToOutput(String.format("%s: snow may cause slight turbulence, stay seated.", getIdentity()));
      coordinates.modifyHeightBy(-7);
    } else {
      fileHandler.addToOutput(String.format("%s: cruising with clear skies and sunny views.", getIdentity()));
      coordinates.modifyLatitudeBy(10);
      coordinates.modifyHeightBy(2);
    }
    super.updateConditions();
  }
}
