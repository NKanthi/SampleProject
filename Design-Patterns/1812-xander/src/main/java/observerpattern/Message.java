package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Message implements Subject {

  private List<Observer> observers = new ArrayList<Observer>();
  private String message;
  private boolean changed;

  public Message() {

  }

  public void register(Observer obj) {
    observers.add(obj);
  }

  public void unregister(Observer obj) {
    observers.remove(obj);
  }

  public void notifyObservers() {
    List<Observer> observersLocal = new ArrayList<Observer>(observers);

    for (Observer obj : observersLocal) {
      obj.update();
    }
  }

  public Object getUpdate(Observer obj) {
    return message;
  }

  public void postMessage(String msg) {
    message = msg;
    changed = true;
    notifyObservers();
  }
}
