/**
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn
 */
package chess;

import java.util.Scanner;

/**
 * This is where Main is located. Starts the game and takes input for the user, as
 * well as displaying output like invalid movements
 */
public class Chess {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean whitesMove = true;
        boolean gameOn = true;
        boolean drawOn = false;
        Board board = new Board();



        board.printBoard();
        while(gameOn) {


            if(board.checkMate(whitesMove)) {
                if(whitesMove) {
                    System.out.println("Black wins");
                }else {
                    System.out.println("White wins");
                }
                break;
            }
            while(whitesMove) {
                System.out.println("\n White's move: ");
                String move = scan.nextLine();
                String[] splitMove = move.split(" ");

                //Event of Resign

                if(splitMove.length == 1) {
                    String resign = splitMove[0];

                    if(drawOn) {
                        if(resign.equals("draw")){
                            gameOn = false;
                            break;
                        }
                    }else if(resign.equals("resign")) {
                        gameOn = false;
                        System.out.println("Black wins");
                        break;
                    }else {

                    }
                }else if(splitMove.length == 2) {
                    String from = splitMove[0];
                    String to = splitMove[1];
                    if(board.createMove(from, to, whitesMove, null)) {
                        whitesMove = !whitesMove;
                    }else {
                        System.out.println("Invalid move");

                    }
                }else if(splitMove.length == 3) {
                    String from = splitMove[0];
                    String to = splitMove[1];
                    String draw = splitMove[2];

                    if(draw.equals("Q") || draw.equals("N")|| draw.equals("B")|| draw.equals("R")) {
                        if(to.equals("a8") || to.equals("b8") || to.equals("c8") || to.equals("d8") || to.equals("e8") || to.equals("f8")||to.equals("h8")) {
                            if(board.createMove(from, to, whitesMove, draw)) {
                                whitesMove = !whitesMove;
                            }else {
                                System.out.println("Invalid move");
                            }
                        }else {
                            System.out.println("Invalid move");
                        }

                    }else if(board.createMove(from, to, whitesMove,null) && draw.equals("draw?")){
                        whitesMove = !whitesMove;
                        drawOn = true;
                    }else {
                        System.out.println("Invalid move");
                    }
                }


                if(gameOn) {
                    board.printBoard();
                }
            }while(!whitesMove){
                System.out.println("\n Black's move: ");


                String move = scan.nextLine();
                String[] splitMove = move.split(" ");


                if(splitMove.length == 1) {
                    String resign = splitMove[0];
                    if(drawOn) {
                        if(resign.equals("draw")) {
                            gameOn = false;
                            break;
                        }
                    }else if(resign.equals("resign")) {
                        gameOn = false;
                        System.out.println("White wins");
                        break;
                    }else {

                    }
                }else if(splitMove.length == 2) {
                    String from = splitMove[0];
                    String to = splitMove[1];
                    if(board.createMove(from, to, whitesMove,null)) {
                        whitesMove = !whitesMove;
                    }else {
                        System.out.println("Invalid move");

                    }
                }else if(splitMove.length == 3) {
                    String from = splitMove[0];
                    String to = splitMove[1];
                    String draw = splitMove[2];
                    if(draw.equals("Q") || draw.equals("N")|| draw.equals("B")|| draw.equals("R")) {
                        if(to.equals("a1") || to.equals("b1") || to.equals("c1") || to.equals("d1") || to.equals("e1") || to.equals("f1")||to.equals("h1")) {
                            if(board.createMove(from, to, whitesMove, draw)) {
                                whitesMove = !whitesMove;
                            }else {
                                System.out.println("Invalid move");
                            }
                        }else {
                            System.out.println("Invalid move");
                        }
                    }
                    else if(board.createMove(from, to, whitesMove,null) && draw.equals("draw?")){
                        whitesMove = !whitesMove;
                        drawOn = true;
                    }else {
                        System.out.println("Invalid move");
                    }
                }

            }
            if(gameOn)
                board.printBoard();

        }
        scan.close();

    }

}