package aircraft;

import tower.WeatherTower;

public abstract class Flyable {
  protected WeatherTower weatherTower;

  public abstract String getIdentity();

  public abstract void updateConditions();

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    this.weatherTower.register(this);
  }
}
