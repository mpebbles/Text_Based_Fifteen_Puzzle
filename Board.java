//////////////////////////////////////////////////////////////////////
///
///  Class to create board with random arrangement
///
//////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

public class Board {
  private static int holder, holder1, holder2, temp, i, j;
  private static final String SPACES = "     ";
  private static Integer[][] board = new Integer[4][4];
  private static ArrayList<Integer> elements = new ArrayList<>();

  public static Integer[][] newBoard() {
    System.out.println("Creating new board...");
    for(i = 1; i <= 15; i++)
        elements.add(i);

    for(i = 0; i < board.length; i++){
      for(j = 0; j < board[i].length; j++) {
        if(elements.size()==0) {
	  //Randomize empy spot
	  holder1 = (int)(Math.random() * 3);
	  holder2 = (int)(Math.random() * 3);
	  temp = board[holder1][holder2];
	  board[holder1][holder2] = -1;
          board[i][j] = temp;
          return board;
        }
        else {
          holder = (int)(Math.random() * elements.size());
          board[i][j] = elements.get(holder);
          elements.remove(holder);
        }
      }
    }
    return board;
  }

  public static boolean executeMove(int moving, String direction) {
    int indexI = -1;
    int indexJ = -1;
    int indexStarI = -1;
    int indexStarJ = -1;
    for(i=0; i < board.length; i++) {
      for(j=0; j < board.length; j++) {
        if(board[i][j]==moving){
	  indexI = i;
	  indexJ = j;
        }
	else if(board[i][j]==-1) {
	  indexStarI = i;
          indexStarJ = j;
        }
      }
    }
    if(indexI==-1 || indexJ==-1)
      return false;
    if(direction.equals("w") && indexJ==indexStarJ && indexI-1==indexStarI ) {
      temp = board[indexI][indexJ];
      board[indexI][indexJ] = -1;
      board[indexStarI][indexStarJ] = temp;
      return true;
    }
    if(direction.equals("a") && indexI==indexStarI && indexJ-1==indexStarJ) {
      temp = board[indexI][indexJ];
      board[indexI][indexJ] = -1;
      board[indexStarI][indexStarJ] = temp;
      return true;
    }
    if(direction.equals("s") && indexJ==indexStarJ && indexI+1==indexStarI ) {
      temp = board[indexI][indexJ];
      board[indexI][indexJ] = -1;
      board[indexStarI][indexStarJ] = temp;
      return true;
    }
    if(direction.equals("d") && indexI==indexStarI && indexJ+1==indexStarJ ) {
      temp = board[indexI][indexJ];
      board[indexI][indexJ] = -1;
      board[indexStarI][indexStarJ] = temp;
      return true;
    }

    return false;
  }

  public static void printBoard() {
    String[][] formatter = new String[4][4];
    for(i=0; i < formatter.length; i++) {
      for(j=0; j < formatter[i].length; j++) {
	String placeHolder = "" + board[i][j];
        if(placeHolder.equals("-1"))
          placeHolder=" *";
	if(placeHolder.length()==1)
	  placeHolder = " " + placeHolder;
	formatter[i][j] = placeHolder;
      }
    }
    for(i=0; i < formatter.length; i++){
      System.out.println(formatter[i][0] + SPACES + formatter[i][1] + SPACES + formatter[i][2] + SPACES + formatter[i][3]);
      System.out.println();
    }
  }

  public static boolean checkWin() {
    if(board[0][0]==1 && board[0][1]==2 && board[0][2]==3 && board[0][3]==4
         && board[1][0]==5 && board[1][1]==6 && board[1][2]==7 && board[1][3]==8
           && board[2][0]==9 && board[2][1]==10 && board[2][2]==11 && board[2][3]==12
             && board[3][0]==13 && board[3][1]==14 && board[3][2]==15 && board[3][3]==-1)
      return true;
    else
      return false;
  }
}

