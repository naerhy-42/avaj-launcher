package simulator;

import aircraft.AircraftFactory;
import coordinates.Coordinates;
import tower.WeatherTower;

public class Simulator {
  public static void main(String[] args) {
    WeatherTower weatherTower = new WeatherTower();
    AircraftFactory.getInstance().newAircraft("Baloon", "B1", new Coordinates(2, 3, 20)).registerTower(weatherTower);;
    AircraftFactory.getInstance().newAircraft("Baloon", "B2", new Coordinates(1, 8, 66)).registerTower(weatherTower);;
    AircraftFactory.getInstance().newAircraft("JetPlane", "J1", new Coordinates(23, 44, 32)).registerTower(weatherTower);;
    AircraftFactory.getInstance().newAircraft("Helicopter", "H1", new Coordinates(654, 33, 20)).registerTower(weatherTower);;
    AircraftFactory.getInstance().newAircraft("Helicopter", "H2", new Coordinates(22, 33, 44)).registerTower(weatherTower);;
    AircraftFactory.getInstance().newAircraft("Helicopter", "H3", new Coordinates(98, 68, 99)).registerTower(weatherTower);;
    for (int i = 0; i < 25; i++) {
      weatherTower.changeWeather();
    }
  }
}
