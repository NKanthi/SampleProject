import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {

    private static final Path PATH = Paths.get("random");
    private static final int NUM_OF_FOLDERS = 3;

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.createFolderStructure();
        demo.hideTextFile();
        demo.displayFolderStructure();
        demo.searchTextFile();
        demo.deleteFolderStructure();
    }

    private void createFolderStructure() {
        for(int i = 0; i < NUM_OF_FOLDERS; i++) {
            File file = new File(getFolderName(i));
            file.mkdirs();
        }
    }

    private String getFolderName(int i) {
        return PATH.resolve(String.valueOf(i)).toString();
    }

    private void hideTextFile() {
        Random random = new Random();
        Path hiddenPath = Paths.get(getFolderName(random.nextInt(NUM_OF_FOLDERS)));
        try {
            Files.createFile(hiddenPath.resolve("hidden.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayFolderStructure() {
        try {
            Files.list(PATH)
                    .filter(Files::isDirectory)
                    .map(Path::toString)
                    .forEach(System.out::println);
            promptInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void promptInput() {
        System.out.println("Please press enter");
        new Scanner(System.in).nextLine();
    }

    private void searchTextFile() {
        try {
            List<File> fileList = Files.walk(PATH)
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            System.out.println(fileList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFolderStructure() {
        try {
            Files.walk(PATH)
                    .map(Path::toFile)
                    .sorted(Comparator.comparing(File::isDirectory) )
                    .forEach(File::delete);
            Files.deleteIfExists(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
