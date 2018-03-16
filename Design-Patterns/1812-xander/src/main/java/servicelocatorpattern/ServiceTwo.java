package servicelocatorpattern;

public class ServiceTwo implements Service {

  private String name = "ServiceTwo";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void execute() {
    System.out.println("Executing service two");
  }
}
