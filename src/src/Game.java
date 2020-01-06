
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Base.drawBase();
        DrawWord.drawTemp();
        System.out.println();
        while (true) {
            System.out.print("Guess a letter: ");
        String userGuess = reader.nextLine();
        System.out.println(WordGuess.indexOfGuess(userGuess));
        }

        //DrawWord.word(WordGuess.indexOfGuess(userGuess));
    }


}
