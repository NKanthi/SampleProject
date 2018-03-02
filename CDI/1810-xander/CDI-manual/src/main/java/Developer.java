import javax.inject.Inject;

public class Developer {


  @Inject
  Coffee coffee;

  public void work() {
    System.out.println(coffee.drink() + " " + "Hammers away at the keyboard");
  }

}
