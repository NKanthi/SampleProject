package servicelocatorpattern;

public class Lookup {
  public Service lookup(String serviceName) {
    if(serviceName.equalsIgnoreCase("serviceOne")) {
      return new ServiceOne();
    } else if(serviceName.equalsIgnoreCase("serviceTwo")) {
      return new ServiceTwo();
    } else  if (serviceName.equalsIgnoreCase("serviceThree")) {
      return new ServiceThree();
    }
    return null;
  }
}
