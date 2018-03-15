package iteratorpattern;

public class Person {
  private String name;
  private String occupation;

  public Person(String name, String occupation) {
    this.name = name;
    this.occupation = occupation;
  }

  public String getName() {
    return name;
  }

  public String getOccupation() {
    return occupation;
  }
}
