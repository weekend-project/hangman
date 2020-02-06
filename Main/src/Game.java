import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TODO make a method that draws remaining body parts (multiD Array and nested for loops)

public class Game {

//    public static int numOfPlayers;
    public static int difficulty;

    public static void newGame(int difficulty) {

    }

    public static ArrayList<String> getAlphabet() {
        ArrayList<String> alphabet = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K",
                "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        return alphabet;
    }

    public static void difficultySelect() {
        Scanner readerDifficulty = new Scanner(System.in);
        System.out.println();
        System.out.println("Select your difficulty:");
        System.out.println();
        System.out.println("      Easy - 1");
        System.out.println("    Medium - 2");
        System.out.println("      Hard - 3");
        System.out.print("> ");
        difficulty = readerDifficulty.nextInt();
        while (difficulty < 1 || difficulty > 3) {
            System.out.println("You must enter a valid option");
            System.out.print("> ");
            difficulty = readerDifficulty.nextInt();
        }
    }
}
