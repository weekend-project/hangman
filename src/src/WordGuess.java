import java.util.ArrayList;

public class WordGuess {

    public static ArrayList<Integer> indexOfGuess(String userGuess) {
        ArrayList<Integer> index = new ArrayList<>();               // creates the ArrayList to hold the unknown number of index values
        if (WordPool.word1.contains(userGuess)) {                   // true if word1 contains at least one occurrence of userGuess
            for (int i = 0; i < WordPool.word1.length(); i++) {     // repeats for the length word1
                if (userGuess.equalsIgnoreCase(String.valueOf(WordPool.word1.charAt(i)))) {   // true if the userGuess is equal to the char at index i
                    index.add(i);                                   // adds the index of the matching char to the ArrayList
                }
            }
        }
        return index;
    }

}
