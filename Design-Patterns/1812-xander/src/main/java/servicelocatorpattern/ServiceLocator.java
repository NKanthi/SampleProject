package servicelocatorpattern;

public class ServiceLocator {
  private static Cache cache;

  static {
    cache = new Cache();
  }

  public static Service getService(String serviceName) {
    Service service = cache.getService(serviceName);

    if (service != null) {
      return  service;
    }

    Lookup lk = new Lookup();
    service = lk.lookup(serviceName);
    cache.addService(service);
    return service;
  }

}
