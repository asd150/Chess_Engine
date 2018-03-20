/**
 * @author Roman Stashchyshyn
 * @author Arthkumar Desai
 *
 */
package chess;

import java.util.ArrayList;

/**
 * Rook class that is an extension of Piece
 */
public class Rook extends Piece{

    public Rook(String team) {
        super("R");
        this.team = team;
    }

    /**
     *
     * @param board
     * @return moves - Returns an arraylist of possible moves/ move kills for Rook
     */
    public ArrayList<String> movePiece(Tile[][] board) {

        ArrayList<String> moves = new ArrayList<String>();

        int right = row+1;
        int left = row-1;
        int down = column+1;
        int up = column-1;

        boolean maxUp = false;
        boolean maxDown = false;
        boolean maxRight = false;
        boolean maxLeft = false;


        if(team.equals("w")) {

            while(down < 8 && !maxDown) {
                if(board[down][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    down++;
                    //System.out.println(moves)
                }else if(board[down][row].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    maxDown=true;
                    //System.out.println(moves)
                }else {
                    maxDown=true;
                }
            }
            while(up > -1 && !maxUp) {

                if(board[up][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    up--;
                    //System.out.println(moves)
                }else if(board[up][row].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    maxUp=true;
                    //System.out.println(moves)
                }else {
                    maxUp=true;
                }
            }
            while(right < 8 && !maxRight) {

                if(board[column][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    right++;
                    //System.out.println(moves)
                }else if(board[column][right].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    maxRight=true;
                    //System.out.println(moves)
                }else {
                    maxRight=true;
                }
            }
            while(left > -1 && !maxLeft) {

                //System.out.println(left);
                if(board[column][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    left--;
                    //System.out.println(moves)
                }else if(board[column][left].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    maxLeft=true;
                    //System.out.println(moves)
                }else {
                    maxLeft=true;
                }
            }
        }if(team.equals("b")) {

            while(down < 8 && !maxDown) {
                if(board[down][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    down++;
                    //System.out.println(moves)
                }else if(board[down][row].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    maxDown=true;
                    //System.out.println(moves)
                }else {
                    maxDown=true;
                }
            }
            while(up > -1 && !maxUp) {

                if(board[up][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    up--;
                    //System.out.println(moves)
                }else if(board[up][row].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    maxUp=true;
                    //System.out.println(moves)
                }else {
                    maxUp=true;
                }
            }
            while(right < 8 && !maxRight) {

                if(board[column][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    right++;
                    //System.out.println(moves)
                }else if(board[column][right].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    maxRight=true;
                    //System.out.println(moves)
                }else {
                    maxRight=true;
                }
            }
            while(left > -1 && !maxLeft) {

                if(board[column][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    left--;
                    //System.out.println(moves)
                }else if(board[column][left].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    maxLeft=true;
                    //System.out.println(moves)
                }else {
                    maxLeft=true;
                }
            }
        }



        //System.out.println(moves);
        return moves;

    }



}