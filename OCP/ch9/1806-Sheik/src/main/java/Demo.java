import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Demo {

    private static final Path PATH = Paths.get("random");

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setupFolderStructure();
        demo.hideTextFile();
        demo.displayFolderStructure();
        demo.searchTextFile();
        demo.deleteFolderStructure();
    }

    private void setupFolderStructure() {
        for(int i = 0; i < 3; i++) {
            File file = new File(String.valueOf(PATH.resolve(String.valueOf(i))));
            file.mkdirs();
        }
    }

    private void hideTextFile() {
        Random random = new Random();
        Path hiddenPath = PATH.resolve(Paths.get(String.valueOf(random.nextInt(3))));

        try {
            Files.createFile(hiddenPath.resolve("hidden.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayFolderStructure() {
        try {
            Files.list(PATH)
                    .filter(p -> Files.isDirectory(p))
                    .map(p -> p.toString())
                    .forEach(System.out::println);
            promptInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void promptInput() {
        System.out.println("Please press enter");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTextFile() {
        try {
            Files.walk(PATH)
                    .filter(p -> Files.isRegularFile(p))
                    .map(p -> p.toString())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFolderStructure() {
        deleteFolderStructureRecursively(PATH.toFile().listFiles());
        try {
            Files.deleteIfExists(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFolderStructureRecursively(File[] file) {
        for (File childFile : file) {
            if (childFile.isDirectory()) {
                deleteFolderStructureRecursively(childFile.listFiles());
            }
            childFile.delete();
        }
    }
}
