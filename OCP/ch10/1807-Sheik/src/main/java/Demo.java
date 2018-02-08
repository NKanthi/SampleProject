import java.util.Scanner;

public class Demo {
    private Database database = new Database();
    private Scanner scanner = new Scanner(System.in);
    private boolean isConnected = true;

    public static void main(String[] args) {
        new Demo();
    }

    private Demo() {
        while(isConnected) {
            displayOptions();
            String input = playerInput();
            chooseOption(input);
        }
    }

    private void displayOptions() {
        System.out.println("What do you want to do?");
        System.out.println("(1) INSERT");
        System.out.println("(2) SELECT");
        System.out.println("(3) CLOSE");
    }

    private String playerInput() {
        return scanner.next();
    }

    private void chooseOption(String input) {
        switch (Integer.parseInt(input)) {
            case 1:
                insert();
                break;
            case 2:
                select();
                break;
            case 3:
                System.out.println("Goodbye.");
                isConnected = false;
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    private void insert() {
        System.out.println("Enter name to insert:");
        database.insert(playerInput());
    }

    private void select() {
        System.out.println("Enter name to select:");
        database.select(playerInput());
    }
}