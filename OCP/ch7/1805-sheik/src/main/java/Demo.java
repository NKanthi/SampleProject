import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private ExecutorService service = null;

    private Team a = new Team("Team A");
    private Team b = new Team("Team B");
    private Flag teamA = new Flag("Flag team A");
    private Flag teamB = new Flag("Flag team B");

    public static void main(String[] args) {
        new Demo();
    }

    private Demo() {
        instructions();
        chooseScenario();
    }

    private void instructions() {
        System.out.println("Please choice a scenario \'deadlock\' or \'livelock\'");
    }

    private void chooseScenario() {
        Scanner scanner = new Scanner(System.in);

        switch (scanner.next()) {
            case "deadlock":
                deadlock();
                break;
            case "livelock":
                livelock();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }
    }

    private void deadlock() {
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> a.deadlock(teamB, teamA));
            service.submit(() -> b.deadlock(teamA, teamB));
        } finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }

    private void livelock() {
        ExecutorService service = null;

        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> a.livelock(b, teamA));
            service.submit(() -> b.livelock(a, teamB));
        } finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }
}
