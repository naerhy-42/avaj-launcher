package weather;

import coordinates.Coordinates;

public final class WeatherProvider {
  private static WeatherProvider instance; // default uninitialized value = null
  private String[] weather;

  private WeatherProvider() {
    weather = new String[]{"rain", "fog", "sun", "snow"};
  }

  public static WeatherProvider getInstance() {
    if (instance == null) {
      instance = new WeatherProvider();
    }
    return instance;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    int i = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length;
    return weather[i];
  }
}
