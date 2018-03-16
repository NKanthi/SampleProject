package builderpattern;

public class PersonBuilder {
  private String name = "Jane Doe";
  private int age = 18;
  private String occupation = "unknown";
  private boolean canDance = false;

  public PersonBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public PersonBuilder withAge(int age) {
    this.age = age;
    return this;
  }

  public PersonBuilder withCanDance(boolean bool) {
    this.canDance = bool;
    return this;
  }

  public PersonBuilder withOccupation (String occupation) {
    this.occupation = occupation;
    return this;
  }

  public Person build() {
    return new Person(age, name, occupation, canDance);
  }



}
