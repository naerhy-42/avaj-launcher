package simulator;

import aircraft.AircraftFactory;
import coordinates.Coordinates;
import exceptions.InvalidArgumentsException;
import file.FileHandler;
import tower.WeatherTower;
import validator.Validator;

public class Simulator {
  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        throw new InvalidArgumentsException();
      }
      Validator validator = new Validator();
      validator.parseFile(args[0]);
      WeatherTower weatherTower = new WeatherTower();
      for (Validator.AircraftInfo ai : validator.getAircraftInfo()) {
        AircraftFactory.getInstance().newAircraft(ai.getType(), ai.getName(), new Coordinates(ai.getLongitude(), ai.getLatitude(), ai.getHeight())).registerTower(weatherTower);
      }
      for (int i = 0; i < validator.getIterations(); i++) {
        weatherTower.changeWeather();
      }
      FileHandler.getInstance().writeOutputToFile();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
