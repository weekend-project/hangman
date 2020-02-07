import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

//TODO make a method that draws remaining body parts (multiD Array and nested for loops)

public class Game {

    private static ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

//    public static int numOfPlayers;
    public static int difficulty;
    public static String word;
    public static ArrayList<Character> wordArray = new ArrayList<>();

    private static int notFound = 0;
    private static int wasFound = 0;

    public static void newGame(int difficulty) throws FileNotFoundException {
        Draw.drawSplash();
        System.out.println();
        difficultySelect();
        Draw.drawFigure(notFound);
        printBlankWord();
        printRemainingLetters();
        makeWordArray();
        chooseLetter();
        updateWord();
    }

    public static void printBlankWord() throws FileNotFoundException {
        System.out.println();
        System.out.print("Your word: ");
        word = WordPool.getWord(difficulty).toUpperCase();
        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
    }

    public static void printRemainingLetters() {
        System.out.println();
        System.out.println("Remaining letters: ");
        for (String s : alphabet) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void makeWordArray() {
        for (int i = 0; i < word.length(); i++) {
            wordArray.add('_');
        }
    }

    public static void chooseLetter() {
        Scanner readerChooseLetter = new Scanner(System.in);
        System.out.println();
        System.out.print("Choose a letter: ");
        char letterPick = readerChooseLetter.next().charAt(0); // sets user choice as a char so it can be compared to word.charAt(i)
        char letterPickUpper = Character.toUpperCase(letterPick);
        String letterPickString = Character.toString(toUpperCase(letterPick)); // creates a copy of user choice as a string so it can be used in word.contains()
        removeFromAlphabet(letterPickString);
        checkForLetter(letterPickString,letterPickUpper,letterPick,wordArray);
    }

    public static void removeFromAlphabet(String letterPickString) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (letterPickString.equals(alphabet.get(i))) {
                alphabet.remove(i);
                break;
            }
        }
    }

    public static void checkForLetter(String letterPickString, char letterPickUpper, char letterPick,
                                      ArrayList<Character> wordArray) {
        if (word.contains(letterPickString)) {
            wasFound++;
            System.out.println();
            System.out.println("'" + letterPickUpper + "'" + " was found!");
            System.out.println();
            for (int i = 0; i < word.length(); i++) { // cycles through each char in the word,
                if (letterPickUpper == (word.charAt(i))) { // if it matches,
                    wordArray.set(i, Character.toUpperCase(letterPick));
                }
            }
        } else {
            notFound++;
            Draw.drawFigure(notFound);
            System.out.println();
            System.out.println("'" + letterPickUpper + "'" + " was not found, tray again :-(");
            System.out.println();
        }
    }

    public static void updateWord() {
        System.out.print("Your word: ");
        for (Character character : wordArray) {
            System.out.print(character + " ");
        }
    }

    public static void printRemainingWords() {
        System.out.println();
        System.out.println("Remaining letters: ");
        for (String s : alphabet) {
            System.out.print(s + " ");
        }
        System.out.println();
    }



//    public static ArrayList<String> getAlphabet(String letter) {
//        ArrayList<String> alphabet = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K",
//                "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
//        alphabet.removeIf(letter::equals);
//        return alphabet;
//    }

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
