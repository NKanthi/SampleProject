import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        new Demo().display(Locale.getDefault());
    }

    private void display(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("demo", locale);
        rb.keySet() .stream()
                    .sorted()
                    .map(key -> rb.getString(key))
                    .forEach(System.out::println);
        playerInput();
    }

    private void playerInput() {
        Scanner scanner = new Scanner(System.in);
        changeLocale(scanner.next());
    }

    private void changeLocale(String input) {
        String language = "";
        String region = "";

        switch (input) {
            case "1":
                language = "en";
                region = "US";
                break;
            case "2":
                language = "nl";
                region = "NL";
                break;
            case "3":
                language = "de";
                region = "DE";
                break;
            default:
                System.out.println("Invalid choice");
                playerInput();
                break;
        }

        Locale locale = new Locale.Builder()
                                .setLanguage(language)
                                .setRegion(region)
                                .build();

        display(locale);
    }
}
