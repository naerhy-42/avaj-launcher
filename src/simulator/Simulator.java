package simulator;

import aircraft.AircraftFactory;
import coordinates.Coordinates;
import file.FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tower.WeatherTower;

public class Simulator {
  public static void main(String[] args) {
    if (args.length == 1) {
      File file = new File(args[0]);
      try {
        Scanner sc = new Scanner(file);
        Integer nbIterations = 0;
        List<String> aircraftLines = new ArrayList<String>();
        boolean isFirstLine = true;
        while (sc.hasNextLine()) {
          if (isFirstLine) {
            nbIterations = Integer.valueOf(sc.nextLine());
            isFirstLine = false;
          } else {
            aircraftLines.add(sc.nextLine());
          }
        }
        sc.close(); // close() in finally if error [?]
        WeatherTower weatherTower = new WeatherTower();
        for (String s : aircraftLines) {
          String[] info = s.split(" ");
          AircraftFactory.getInstance().newAircraft(info[0], info[1], new Coordinates(Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]))).registerTower(weatherTower);
        }
        for (int i = 0; i < nbIterations; i++) {
          weatherTower.changeWeather();
        }
        FileHandler.getInstance().writeOutputToFile();
      } catch (Exception e) {
        if (e instanceof FileNotFoundException) {
          System.out.println("Error: file does not exist");
        } else if (e instanceof NumberFormatException) {
          System.out.println("Error: invalid iterations number");
        }
      }
    } else {
      System.out.println("Error: invalid number of arguments");
    }
  }
}
