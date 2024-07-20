package simulator;

import aircraft.AircraftFactory;
import coordinates.Coordinates;
import tower.WeatherTower;

public class Simulator {
  public static void main(String[] args) {
    WeatherTower weatherTower = new WeatherTower();
    weatherTower.changeWeather();
    AircraftFactory.getInstance().newAircraft("osef", "prout", new Coordinates(0, 0, 0));
    AircraftFactory.getInstance().newAircraft("osef", "prout", new Coordinates(0, 0, 0));
  }
}
