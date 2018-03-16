package servicelocatorpattern;

import java.util.ArrayList;
import java.util.List;

public class Cache {
  private List<Service> services = new ArrayList<>();

  public Service getService(String serviceName) {
    for (Service service: services) {
      if (serviceName.equalsIgnoreCase(service.getName())) {
        System.out.println("cached: " + service.getName());
        return service;
      }
    }
    return null;
  }

  public void addService(Service newService) {
    boolean exist = false;

    for (Service service : services) {
      if (newService.getName().equalsIgnoreCase(service.getName())) {
        exist = true;
      }
    }

    if (!exist) {
      services.add(newService);
    }

  }

}
