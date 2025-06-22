import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        return switch (choice) {
            case 0 -> "rock";
            case 1 -> "paper";
            default -> "scissors";
        };
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock")))
            return "User";
        return "Computer";
    }

    public static void showResults(String[][] results, int userWins, int computerWins, int draws) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2]);
        }

        int total = userWins + computerWins + draws;
        System.out.println("\nStats:");
        System.out.println("User Wins: " + userWins + " (" + (userWins * 100 / total) + "%)");
        System.out.println("Computer Wins: " + computerWins + " (" + (computerWins * 100 / total) + "%)");
        System.out.println("Draws: " + draws);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        String[][] results = new String[n][3];
        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = getWinner(user, comp);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            results[i][0] = user;
            results[i][1] = comp;
            results[i][2] = winner;
        }

        showResults(results, userWins, computerWins, draws);
    }
}
