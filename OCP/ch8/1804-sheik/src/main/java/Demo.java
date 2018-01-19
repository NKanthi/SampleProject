import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Demo {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final int WIN_CONDITION_ONE = -2;
    private static final int WIN_CONDITION_TWO = 1;
    private static final int LOSE_CONDITION_ONE = -1;
    private static final int LOSE_CONDITION_TWO = 2;
    private boolean gameOver = false;
    private int score = 0;

    public static void main(String[] args) {
        new Demo().startGame();
    }

    private void startGame() {
        displayInstructions();
        getInput();
        saveScore();
        checkGameOver();
    }

    private void displayInstructions() {
        System.out.println("Please choose one:\n (1) Rock \n (2) Paper \n (3) Scissors");
    }

    private void getInput() {
        Option playerChoice = playerInput();
        Option computerChoice = computerInput();
        calcResult(playerChoice, computerChoice);
    }

    private Option playerInput() {
        int input = 0;
        try {
            input = Integer.parseInt(SCANNER.next());
        } catch (NumberFormatException ignored) {}
        return checkInput(input);
    }

    private Option computerInput() {
        return checkInput(RANDOM.nextInt(3) + 1);
    }

    private Option checkInput(int input) {
        Option option = null;

        switch(input) {
            case 1:
                option = Option.ROCK;
                break;
            case 2:
                option = Option.PAPER;
                break;
            case 3:
                option = Option.SCISSORS;
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        if (option == null) {
            startGame();
        }

        return option;
    }

    private void calcResult(Option player, Option computer) {
        int result = player.ordinal() - computer.ordinal();

        System.out.println("player: " + player);
        System.out.println("computer: " + computer);

        if (result == WIN_CONDITION_ONE || result == WIN_CONDITION_TWO) {
            score += 1;
            System.out.println("WIN");
        } else if (result == LOSE_CONDITION_ONE || result == LOSE_CONDITION_TWO) {
            gameOver = true;
            System.out.println("LOSE");
        } else {
            System.out.println("DRAW");
        }
    }

    private void saveScore() {
        File file = new File("highscore.txt");

        if(!file.exists()) {
            createFile(file);
        } else {
            writeScoreToFile(file);
        }

        displayScore(file);
    }

    private void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveScore();
    }

    private void writeScoreToFile(File file) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(Integer.toString(score));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayScore(File file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Score: " + reader.readLine() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkGameOver() {
        if (gameOver) {
            this.score = 0;
            gameOver = false;
        }
        startGame();
    }
}
