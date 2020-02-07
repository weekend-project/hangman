import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Main {

    //TODO move contents of main method into Game.java class

    //TODO fix control flow for when user guesses all words correctly, or uses all turns

    //TODO add option to guess full word

    //TODO display full word if user loses

    private static ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

    public static void main(String[] args) throws FileNotFoundException {
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
            // reveal the word
            System.out.println();
            System.out.println("Play again?");
        } else {
            System.out.println("CONGRATULATIONS - You won!");
            System.out.println();
            System.out.println("Play again?");
        }

        // if (yes) { recursive call }
    }

    public static boolean isComplete (String word, ArrayList<Character> wordArray) {
        boolean isComplete = false;
        if (word.contentEquals((CharSequence) wordArray)) {
            isComplete = true;
        }
        return isComplete;
    }

//    public static int playerSelect() {
//        Scanner readerPlayerSelect = new Scanner(System.in);
//        int numOfPlayers = 0;
//        boolean correctInput = false;
//        do {
//            try {
//                System.out.print("How many players?\n  Enter 1 or 2: ");
//                numOfPlayers = Integer.parseInt(readerPlayerSelect.nextLine());
//                while (numOfPlayers < 1 || numOfPlayers > 2) {
//                    System.out.println();
//                    System.out.print("You must enter either 1 or 2: ");
//                    numOfPlayers = Integer.parseInt(readerPlayerSelect.nextLine());
//                }
//                correctInput = true;
//            } catch (Exception e) {
//                System.out.println();
//                System.out.println("You must enter either 1 or 2");
//                System.out.println();
//            }
//        } while (!correctInput);
//        if (numOfPlayers == 2) {
//            System.out.println();
//            System.out.println("2-player game coming soon!");
//        }
//        return numOfPlayers;
//    }


}
