import java.util.ArrayList;

public class DrawWord {

    public static void word(ArrayList<Integer> index) {
        System.out.print("Your word: ");
        String place = "_";
        // if (!index.isEmpty()) {
        for (int i = 0; i < WordPool.word1.length(); i++) {

            System.out.print(place + " ");

        }
        System.out.println();
    }

    public static void drawTemp () {
        System.out.print("Your word: ");
        String place = "_";
        // if (!index.isEmpty()) {
        for (int i = 0; i < WordPool.word1.length(); i++) {

            System.out.print(place + " ");

        }
        System.out.println();

    }
}

