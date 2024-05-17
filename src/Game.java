import java.util.Scanner;

public class Game {

    Board b1 = new Board();
    Player p1 = new Player("X");
    Player p2 = new Player("O");
    Player currentPlayer = p1;
    void play(){
        try {
            b1.addElements();
            String message = "enter the position (1 - 9):";
            while (true) {
                message = "enter the position (1 - 9):";
                System.out.println(currentPlayer.name + " " + message);
                Scanner input = new Scanner(System.in);
                int position = input.nextInt();

                if (b1.updateBoard(position, currentPlayer.type)) {
                    b1.printBoard();
                    if (b1.checkWinner(currentPlayer.type)) {
                        System.out.println(currentPlayer.name + " wins!");
                        break;
                    } else if (b1.checkDraw()) {
                        System.out.println("Game is a draw!");
                        break;

                    } else {
                        if (currentPlayer == p1) {
                            currentPlayer = p2;
                        } else {
                            currentPlayer = p1;
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid input! Enter a number between 1 and 9.");

            }
    }

}
