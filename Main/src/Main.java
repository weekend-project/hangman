import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Main {

    //TODO add option to guess full word

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        Scanner readerMain = new Scanner(System.in);
        int notFound = 0;
        int wasFound = 0;
        Draw.drawSplash();
        System.out.println();
        Game.difficultySelect();
        Draw.drawFigure(notFound);
        System.out.println();
        System.out.print("Your word: ");
        String word = WordPool.getWord(Game.difficulty).toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Remaining letters: ");
        for (String s : alphabet) {
            System.out.print(s + " ");
        }
        System.out.println();
        ArrayList<Character> wordArray = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordArray.add('_');
        }

        do {
            System.out.println();
            System.out.print("Choose a letter: ");
            char letterPick = readerMain.next().charAt(0); // sets user choice as a char so it can be compared to word.charAt(i)
            char letterPickUpper = Character.toUpperCase(letterPick);
            String letterPickString = Character.toString(toUpperCase(letterPick)); // creates a copy of user choice as a string so it can be used in word.contains()
            for (int i = 0; i < alphabet.size(); i++) {
                if (letterPickString.equals(alphabet.get(i))) {
                    alphabet.remove(i);
                    break;
                }
            }
            if (word.contains(letterPickString)) {
                wasFound++;
                for (int i = 0; i < word.length(); i++) { // cycles through each char in the word,
                    if (letterPickUpper == (word.charAt(i))) { // if it matches,
                        wordArray.set(i, Character.toUpperCase(letterPick));
                    }
                }
                if (isComplete(word,wordArray)) {
                    break;
                }
                System.out.println();
                System.out.println("'" + letterPickUpper + "'" + " was found!");
                System.out.println();

            } else {
                notFound++;
                Draw.drawFigure(notFound);
                if (notFound == 6) {
                    break;
                }
                System.out.println();
                System.out.println("'" + letterPickUpper + "'" + " was not found, tray again :-(");
                System.out.println();
            }
            System.out.print("Your word: ");
            for (Character character : wordArray) {
                System.out.print(character + " ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Remaining letters: ");
            for (String s : alphabet) {
                System.out.print(s + " ");
            }
            System.out.println();

        } while (notFound < 6 || isComplete(word,wordArray));
        System.out.println();
        if (notFound == 6) {
            System.out.println("GAME OVER - You lost!");
            System.out.println();
            System.out.print("The word was: ");
            for (int i = 0; i < word.length(); i++) {
                System.out.print(word.toUpperCase().charAt(i) + " ");
            }
            System.out.print("!!!");
            System.out.println();
            System.out.println();
            System.out.println("Play again?");
            System.out.println();
            System.out.println("    Yes - 1");
            System.out.println("     No - 0");
            System.out.print("> ");
            int playAgain = readerMain.nextInt();
            if (playAgain == 1) {
                main(args);
            } else {
                System.out.println("Thanks for playing!");
            }

        } else {
            System.out.println("CONGRATULATIONS - You won!");
            System.out.println();
            System.out.println("Play again?");
            System.out.println();
            System.out.println("    Yes - 1");
            System.out.println("     No - 0");
            System.out.print("> ");
            int playAgain = readerMain.nextInt();
            if (playAgain == 1) {
                main(args);
            } else {
                System.out.println("Thanks for playing!");
            }
        }
    }

    public static boolean isComplete (String word, ArrayList<Character> wordArray) {
        boolean isComplete = false;
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == wordArray.get(i)) {
                counter++;
            }
        }
        if (counter == word.length()) {
            isComplete = true;
        }
        return isComplete;
    }
}
