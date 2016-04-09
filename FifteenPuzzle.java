import java.util.Scanner;

public class FifteenPuzzle {
  public static void main(String[] args) {
    String input = "";
    boolean continueGame = true;
    boolean currentGame, validMove;
    int numberToMove;
    Scanner scan = new Scanner(System.in);
    Integer[][] gameBoard;

    System.out.println("**********************************************************");
    System.out.println("Fifteen Puzzle - Created by Mitchell Pebbles - 2 Jan 2016");
    System.out.println();
    System.out.println("Objective: Arrange numbers in order horizontally from 1-15 \nwith the * in the bottom right corner");
    System.out.println("*********************************************************");
    System.out.println();

    while(continueGame) {
      gameBoard = Board.newBoard();
      currentGame = true;
      while(currentGame) {
	System.out.println();
        Board.printBoard();
	System.out.println();
        System.out.println("w = up, a = left, s = down, d = right");
	System.out.print("Number to move: ");
	numberToMove = scan.nextInt();
        while(!(numberToMove==1 || numberToMove==2 || numberToMove==3 || numberToMove==4 || numberToMove==5
                  || numberToMove==6 || numberToMove==7 || numberToMove==8 || numberToMove==9 || numberToMove==10
                        || numberToMove==11 || numberToMove==12 || numberToMove==13 || numberToMove==14 || numberToMove==15)) {
          System.out.println("Invalid input.");
          numberToMove = scan.nextInt();

        }
        System.out.print("Direction to move: ");
        input = scan.next();
	while(!(input.equalsIgnoreCase("w") || input.equalsIgnoreCase("a") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("d"))){
          System.out.println("Invalid input.");
	  System.out.println("Direction to move: ");
	  input = scan.next();
        }
	validMove = Board.executeMove(numberToMove, input);
        if(!validMove) {
	  System.out.println("**************");
	  System.out.println("Invalid move.");
          System.out.println("**************");
	}
	  System.out.println();
        if(Board.checkWin()) {
  	  System.out.println("You won!");
          System.out.print("New Game? [y/n]: ");
          input = scan.next();
	  while(!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))){
            System.out.println("Invalid input.");
	    System.out.print("New Game? [y/n]: ");
            input = scan.next();
          }
          if(input.equalsIgnoreCase("n")) {
            continueGame = false;
	    System.out.println("Exiting program.");
          }
	  currentGame = false;
        }
      }
    }
  }
}

