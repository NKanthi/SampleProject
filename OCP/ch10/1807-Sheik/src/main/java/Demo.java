import java.util.Scanner;

public class Demo {

    Database database = new Database();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.displayOptions();
        demo.playerInput();
        demo.chooseOption();
    }

    private void displayOptions() {
        System.out.println("What do you want to do?");
        System.out.println("(1) INSERT");
        System.out.println("(2) SELECT");
    }

    private String playerInput() {
        return scanner.next();
    }

    private void chooseOption() {
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                insert();
                break;
            case 2:
                select();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void insert() {

    }

    private void select() {
        System.out.println("Who do you want to see?");
        database.select(playerInput());
    }

}