import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Demo {

    private List<Pokemon> pokedex = new ArrayList<>();

    public static void main(String[] args) {
        new Demo();
    }

    private Demo() {
        populatePokedex();
        playerInput();
    }

    private void populatePokedex() {
        Pokemon pikachu = new Pokemon("pikachu", Type.ELECTRIC, 1, 2,
                "male", "shock", 2, "Sheik");
        pokedex.add(pikachu);

        Pokemon farfetchd = new Pokemon("farfetch'd", Type.NORMAL, 1, 3,
                "non-binary", "keen eye", 2, "Xander");
        pokedex.add(farfetchd);

        Pokemon wartortle = new Pokemon("wartortle", Type.WATER, 2, 3,
                "male", "shell", 3, "Haoran");
        pokedex.add(wartortle);

        Pokemon charizard = new Pokemon("charizard", Type.FIRE, 3, 3,
                "female", "blaze", 4, "Aeron");
        pokedex.add(charizard);

        Pokemon eevee = new Pokemon("eevee", Type.NORMAL, 1, 2,
                "male", "-", 4, "Shadab");
        pokedex.add(eevee);

        Pokemon pigeotto = new Pokemon("pigeotto", Type.FLYING, 2, 3,
                "female", "levitate", 3, "Alfonso");
        pokedex.add(pigeotto);
    }

    private void playerInput() {
        System.out.println("Please enter a pokemon name.");
        Scanner scanner = new Scanner(System.in);
        search(scanner.next());
    }

    private void search(String input) {
        Optional<Pokemon> result = pokedex.stream()
                .filter(pokemon -> pokemon.getName().contains(input))
                .findFirst();

        if (result.isPresent()) {
            print(result);
        } else {
            errorMessage();
        }
    }

    private void print(Optional<Pokemon> result) {
        System.out.println("Name: " + result.get().getName());
        System.out.println("Type: " + result.get().getType().name().toLowerCase());
        System.out.println("Current Evolution Stage: " + result.get().getCurrentEvolutionStage());
        System.out.println("Maximum Evolution Stage: " + result.get().getMaximumEvolutionStage());
        System.out.println("Gender: " + result.get().getGender());
        System.out.println("Ability: " + result.get().getAbility());
        System.out.println("Number of Attacks: " + result.get().getNumberOfAttacks());
        System.out.println("Trainer: " + result.get().getTrainer());
    }

    private void errorMessage() {
        System.out.println("Pokemon not found.");
    }
}