import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readerMain = new Scanner(System.in);
        Draw.drawSplash();
        System.out.println();
        Game.difficultySelect();
        Draw.drawFigure0();
        System.out.println();
        System.out.print("Your word: ");
        String word = WordPool.getWord(Game.difficulty);
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Remaining letters: ");
        for (int i = 0; i < Game.getAlphabet().size(); i++) {
            System.out.print(Game.getAlphabet().get(i) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Choose a letter: ");
        do {
            String letterPick = readerMain.nextLine();
            if (word.contains(letterPick)) {
                System.out.println("Found!");
                //TODO left off here - print updated word
            } else {
                System.out.println("Not found");
            }
        } while (true);




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
