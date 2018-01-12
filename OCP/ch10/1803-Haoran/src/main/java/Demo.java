import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) throws Exception{
        Database database = Database.getInstance();
        Map<Integer, Integer> ageMap = database.getAnimalAge();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        Runnable run = () -> ageMap.entrySet().parallelStream().filter(entry -> entry.getValue()>2).forEach(entry -> System.out.print(entry.getValue() + " "));
        Callable call = () -> ageMap.entrySet().parallelStream().filter(entry -> entry.getValue()>2).map(entry -> entry.getKey()).collect(Collectors.toList());

        service.schedule(run, 1, TimeUnit.SECONDS);
        Future result = service.schedule(call, 5, TimeUnit.SECONDS);

        System.out.println("The id of animal older than 2 : "+ result.get());

        service.shutdown();

    }

}
