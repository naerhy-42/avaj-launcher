package weather;

import coordinates.Coordinates;

public final class WeatherProvider {
  private static WeatherProvider instance; // default uninitialized value = null
  private String[] weather;

  private WeatherProvider() {
    weather = new String[]{"fog", "rain", "snow", "sun"};
  }

  public static WeatherProvider getInstance() {
    if (instance == null) {
      instance = new WeatherProvider();
    }
    return instance;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    long i = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()
        + System.nanoTime()) % weather.length;
    return weather[(int) i];
  }
}
