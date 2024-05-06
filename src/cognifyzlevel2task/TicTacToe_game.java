
package cognifyzlevel2task;

import java.util.*;
public class TicTacToe_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            playGame(scanner);

            System.out.print("Do you want to play the game again? (Yes/No): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("Yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();

    }

    public static void playGame(Scanner scanner) {

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char currentPlayer = 'X';

        while (true) {
            printBoard(board);

            System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;

                } else if (isDraw(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void printBoard(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");

                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean checkWinner(char[][] board, char player) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        
        return false;
    }

    public static boolean isDraw(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
    

