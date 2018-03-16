package builderpattern;

public class Person {
  private int age;
  private String name;
  private String occupation;
  private boolean canDance;

  public Person(int age, String name, String occupation, boolean canDance) {
    this.age = age;
    this.name = name;
    this.occupation = occupation;
    this.canDance = canDance;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public boolean isCanDance() {
    return canDance;
  }

  public void setCanDance(boolean canDance) {
    this.canDance = canDance;
  }
}
