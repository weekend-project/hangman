import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordPool {

    public static String getWord(int difficulty) throws FileNotFoundException {
        String word = "";
        Random rand = new Random();
        if (difficulty == 1) {
            File fileEasy = new File("easy.txt");
            Scanner reader = new Scanner(fileEasy);
            ArrayList<String> easy = new ArrayList<>();
            while (reader.hasNextLine()) {
                easy.add(reader.nextLine());
            }
            int randomPick = rand.nextInt(easy.size());
            word = easy.get(randomPick);
        } else if (difficulty == 2) {
            File fileMedium = new File("medium.txt");
            Scanner reader = new Scanner(fileMedium);
            ArrayList<String> medium = new ArrayList<>();
            while (reader.hasNextLine()) {
                medium.add(reader.nextLine());
            }
            int randomPick = rand.nextInt(medium.size());
            word = medium.get(randomPick);
        } else {
            File fileHard = new File("hard.txt");
            Scanner reader = new Scanner(fileHard);
            ArrayList<String> hard = new ArrayList<>();
            while (reader.hasNextLine()) {
                hard.add(reader.nextLine());
            }
            int randomPick = rand.nextInt(hard.size());
            word = hard.get(randomPick);
        }
        return word;
    }

}
