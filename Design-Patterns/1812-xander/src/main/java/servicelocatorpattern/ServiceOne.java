package servicelocatorpattern;

public class ServiceOne implements Service {
  private String name = "ServiceOne";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void execute() {
    System.out.println("Executing service one");
  }
}
