package tower;

import aircraft.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {
  private List<Flyable> observers;
  private List<Flyable> observersToRemove;

  public Tower() {
    observers = new ArrayList<Flyable>();
    observersToRemove = new ArrayList<Flyable>();
  }

  public void register(Flyable flyable) {
    observers.add(flyable);
    System.out.printf("Tower says: %s registered to weather tower.%n", flyable.getIdentity());
  }

  public void unregister(Flyable flyable) {
    observersToRemove.add(flyable);
    System.out.printf("Tower says: %s unregistered from weather tower.%n", flyable.getIdentity());
  }

  protected void conditionChanged() {
    for (Flyable f : observers) {
      f.updateConditions();
    }
    removeUnregistered();
  }

  private void removeUnregistered() {
    for (Flyable f : observersToRemove) {
      observers.remove(f);
    }
    observersToRemove.clear();
  }
}
