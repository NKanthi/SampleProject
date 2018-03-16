package servicelocatorpattern;

public class ServiceThree implements Service {

  private String name = "ServiceThree";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void execute() {
    System.out.println("Executing service three");
  }
}
