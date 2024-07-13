import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        char[][] board = new char[3][3];
        char num='1';
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=num++;
            }
        }
        System.out.println("~~~* welcome to _tic tac toe _ game *~~~ ");
        System.out.println("let's start the game :)");
        System.out.println(" your (X)  please chose a number from the board ");
        printboard(board);


        boolean playerturn=true;
        boolean thewinner=false;
        while(!thewinner&&!boardfull(board)){
            if(playerturn){
                System.out.println(".. your turn ..");
                playerturn(board,scanner);
                thewinner=thewinner(board,'X');
            }else{
                System.out.println(" .. Computer's Turn ..");
                computerturn(board,rand);
                thewinner=thewinner(board,'O');
            }
            playerturn =!playerturn;
            printboard(board);





        }
        if(thewinner){
            System.out.println("the game is over!!"+(playerturn?"computer":"player" )+" is the winner :)");

        }else
            System.out.println(" its a tie :|");


    }

    public static void printboard(char board[][]){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
    public static void playerturn(char[][] board,Scanner scanner){
        int turn;
        while(true) {
            System.out.println("enter the number of the position 1-9 :) ");
            try {
                turn = scanner.nextInt();
                if (turn < 1 || turn > 9) {
                    System.out.println("please enter a number between 1-9 :)");
                    continue;
                }

                if (validturn(board, turn)) {
                    placemove(board, turn, 'X');
                    break;


                } else System.out.println(" not valid move :(");


            }catch (Exception e) {
               System.out.println(e.getMessage());
            }
       }
    }
    public static void computerturn(char[][] board, Random random){
        int turn;
        while(true){
            turn=random.nextInt(9)+1;
            if(validturn(board,turn)){
                placemove(board,turn,'O');
                break;
            }
        }

    }

    public  static boolean validturn(char[][] board, int turn) {
        int row = (turn - 1) / 3;
        int col = (turn - 1) % 3;
        return board[row][col] != 'X' && board[row][col] != 'O';
    }
    public  static void placemove(char[][] board, int turn, char player) {
        int row = (turn - 1) / 3;
        int col = (turn - 1) % 3;
        board[row][col] = player;
    }
    public static boolean boardfull(char[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]!='X'&&board[i][j]!='O'){
                    return false;
                }
            }
        }
        return true;
}
public static boolean thewinner(char[][] board,char player) {
        for(int i=0;i<3;i++){
            if(board[0][i]==player&&board[1][i]==player&&board[2][i]==player){
                return true;
            }
        }
        if (board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
        else if (board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }
        return false;
}
}