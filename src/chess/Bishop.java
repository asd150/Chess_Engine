package chess;

/**
 * 2 player Chess
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn*/

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(String team) {
        super("B");
        this.team = team;
    }

    public ArrayList<String> movePiece(Tile[][] board) {

        ArrayList<String> moves = new ArrayList<String>();

        int right = row+1;
        int left = row-1;
        int up = column-1;
        int down = column+1;

        boolean upRightMax = false;
        boolean upLeftMax = false;
        boolean downRightMax = false;
        boolean downLeftMax = false;


        if(team.equals("w")) {

            while(down<8 && right < 8 && !downRightMax) {

                if(board[down][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,right);
                    moves.add(move);
                    down++;
                    right++;
                    //System.out.println(moves);
                }else if(board[down][right].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(down,right);
                    moves.add(move);
                    downRightMax=true;
                    //System.out.println(moves);
                }else {
                    downRightMax=true;
                }
            }

            while(up>-1 && right<8 && !upRightMax) {

                if(board[up][right].getPiece() == null) {
                    String move = "";
                    move = convertMove(up,right);
                    moves.add(move);
                    up--;
                    right++;
                    //System.out.println(moves);
                }else if(board[up][right].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(up,right);
                    moves.add(move);
                    upRightMax=true;
                    //System.out.println(moves);
                }else {
                    upRightMax=true;
                }

            }

            while(down<8 && left > -1 && !downLeftMax) {

                if(board[down][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,left);
                    moves.add(move);
                    down++;
                    left--;
                    //System.out.println(moves);
                }else if(board[down][left].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(down,left);
                    moves.add(move);
                    downLeftMax=true;
                    //System.out.println(moves);
                }else {
                    downLeftMax=true;
                }
            }

            while(up>-1 && left > -1 && !upLeftMax) {

                if(board[up][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,left);
                    moves.add(move);
                    up--;
                    left--;
                }else if(board[up][left].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(up,left);
                    moves.add(move);
                    upLeftMax=true;
                }else {
                    upLeftMax=true;
                }
            }

        }if(team.equals("b")) {

            while(down<8 && right<8 && !downRightMax) {


                if(board[down][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,right);
                    moves.add(move);
                    down++;
                    right++;
                    //System.out.println(moves);
                }else if(board[down][right].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(down,right);
                    moves.add(move);
                    downRightMax=true;
                    //System.out.println(moves);
                }else {
                    downRightMax=true;
                }
            }

            while(up>-1 && right<8 && !upRightMax) {

                if(board[up][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,right);
                    moves.add(move);
                    up--;
                    right++;
                    //System.out.println(moves);
                }else if(board[up][right].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(up,right);
                    moves.add(move);
                    //System.out.println(moves);
                    upRightMax=true;
                }else {
                    upRightMax=true;
                }
            }

            while(down<8 && left > -1 && !downLeftMax) {

                if(board[down][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,left);
                    moves.add(move);
                    down++;
                    left--;
                    //System.out.println(moves);
                }else if(board[down][left].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(down,left);
                    moves.add(move);
                    downLeftMax=true;
                    //System.out.println(moves);
                }else {
                    downLeftMax=true;
                }
            }
            while(up>-1 && left > -1 && !upLeftMax) {
                if(board[up][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,left);
                    moves.add(move);
                    up--;
                    left--;
                    //System.out.println(moves);
                }else if(board[up][left].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(up,left);
                    moves.add(move);
                    //System.out.println(moves);
                    upLeftMax=true;
                }else {
                    upLeftMax=true;
                }
            }


        }



        //System.out.println(moves);
        return moves;

    }


}
