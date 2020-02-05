import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Draw.drawSplash();
        System.out.println();
        playerSelect();
        difficultySelect();

    }

    public static void playerSelect() {
        int numOfPlayers = 0;
        int x = 1;
        do {
            try {
                Scanner reader = new Scanner(System.in);
                System.out.println("How many players?\n  Enter 1 or 2: ");
                numOfPlayers = reader.nextInt();
                x = 2;
            } catch (Exception e) {
                System.out.println("You must enter either 1 or 2");
            }
        } while (x == 1);
        if (numOfPlayers == 2) {
            System.out.println("2-player game coming soon!");
        }
    }

    public static void difficultySelect() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Select your difficulty:");
        System.out.println();
        System.out.println("  Easy - 1");
        System.out.println("Medium - 2");
        System.out.println("  Hard - 3");
        System.out.println();
        int userDifficulty = reader.nextInt();
        while (userDifficulty < 1 || userDifficulty > 3) {
            System.out.println("You must enter a valid option");
            difficultySelect();
        }
        if (userDifficulty == 1) {
            Game.newGame(userDifficulty);
        } else if (userDifficulty == 2) {
            Game.newGame(userDifficulty);
        } else {
            Game.newGame(userDifficulty);
        }
    }
}
