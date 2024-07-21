package tower;

import aircraft.Flyable;
import file.FileHandler;
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
    FileHandler.getInstance().addToOutput(String.format("Tower says: %s registered to weather tower.", flyable.getIdentity()));
  }

  public void unregister(Flyable flyable) {
    observersToRemove.add(flyable);
    FileHandler.getInstance().addToOutput(String.format("Tower says: %s unregistered from weather tower.", flyable.getIdentity()));
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
