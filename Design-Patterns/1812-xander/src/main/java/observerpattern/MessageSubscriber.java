package observerpattern;

public class MessageSubscriber implements Observer {
  private String name;
  private Subject subject;
  private String message;

  public MessageSubscriber(String name) {
    this.name = name;
  }

  public void update() {
    message = (String) subject.getUpdate(this);
    if (message == null) {
      System.out.println("No new message");
    } else {
      System.out.println(name + ": " + message);
    }
  }

  public void setSubject(Subject sub) {
    subject = sub;
  }
}
