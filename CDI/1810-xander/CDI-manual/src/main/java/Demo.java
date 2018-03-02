import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {

private static final Logger LOGGER = Logger.getLogger(Demo.class.getName());

  public static void main(String args[]) {
    try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
      Developer dev = container.select(Developer.class).get();
      dev.work();
    } catch (RuntimeException e) {
      LOGGER.log(Level.SEVERE, e.toString(), e);
      throw e;
    }
  }
}
