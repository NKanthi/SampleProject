import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class Demo {

  public static void main(String args[]) {
    try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
      Developer dev = container.select(Developer.class).get();
      dev.work();
    }
  }
}
