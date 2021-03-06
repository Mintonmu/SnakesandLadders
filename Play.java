
import java.util.HashMap;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(18, 4);
        hashMap.put(15, -1);
        hashMap.put(29, -4);
        hashMap.put(30, -1);
        hashMap.put(32, -4);
        hashMap.put(33, 2);
        hashMap.put(34, -1);
        hashMap.put(48, -3);

        System.out.println("Input 1 to play with AUTO mode, 2 to play with HUMAN mode:");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        if (mode == 1) {
            // Auto
            Player autoPlayerE = new Player('E');
            Player autoPlayerS = new Player('S');

            // Init
            Board gameBoard = new Board(10, 5, hashMap);
            gameBoard.putPlayer(autoPlayerE, 0);
            gameBoard.putPlayer(autoPlayerS, 0);
            System.out.println("Board's rows=" + gameBoard.getRows() + ", cols=" + gameBoard.getCols());
            System.out.println("Board's init state:");
            System.out.println(gameBoard.toString());

            // Play
            while (!gameBoard.takeTurns())
                ;

        } else if (mode == 2) {
            // Human play game
            Player humanPlayerE = new HumanPlayer('E');
            Player humanPlayerS = new HumanPlayer('S');

            Board humanGameBoard = new Board(10, 5, hashMap);
            humanGameBoard.putPlayer(humanPlayerE, 0);
            humanGameBoard.putPlayer(humanPlayerS, 0);

            System.out.println(humanGameBoard.toString());

            while (!humanGameBoard.takeTurns())
                ;
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
        System.out.println("Game Over!");
    }
}
