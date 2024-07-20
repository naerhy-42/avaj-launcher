package tower;

import aircraft.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {
  private List<Flyable> observers;

  public Tower() {
    observers = new ArrayList<Flyable>();
  }

  public void register(Flyable flyable) {
    observers.add(flyable);
  }

  public void unregister(Flyable flyable) {
    observers.remove(flyable);
  }

  protected void conditionChanged() {
    for (Flyable f : observers) {
      f.updateConditions();
    }
  }
}
