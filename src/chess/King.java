/**
 * @author Roman Stashchyshyn
 * @author Arthkumar Desai
 */
package chess;

import java.util.ArrayList;

/**
 * King class. Gets possible moves and kills that the kill can make.
 */
public class King extends Piece{

    public King(String team) {
        super("K");
        this.team = team;
    }

    /**
     *
     * @param board
     * @return moves -- arrayList of moves that the King can make.
     */
    public ArrayList<String> movePiece(Tile[][] board) {

        ArrayList<String> moves = new ArrayList<String>();

        String forward = convertMove(column-1,row);
        String backward = convertMove(column+1,row);
        String right = convertMove(column,row+1);
        String left = convertMove(column,row-1);
        String diagFR = convertMove(column-1,row+1);
        String diagFL = convertMove(column-1,row-1);
        String diagBR = convertMove(column+1,row+1);
        String diagBL = convertMove(column+1,row-1);

        if(team.equals("w")) {

            //moving up/down
            if(column>0) {
                if(board[column-1][row].getPiece() == null || board[column - 1][row].getPiece().getTeam().equals("b")){
                    moves.add(forward);
                    //System.out.println(moves);
                }
            }
            if(column<7) {
                if(board[column+1][row].getPiece() == null || board[column + 1][row].getPiece().getTeam().equals("b")){
                    moves.add(backward);
                    //System.out.println(moves);
                }
            }


            //moving left/right
            if(row>0) {
                if(board[column][row-1].getPiece() == null || board[column][row - 1].getPiece().getTeam().equals("b")) {
                    moves.add(left);
                    //System.out.println(moves);
                }
            }
            if(row<7) {
                if(board[column][row+1].getPiece() == null || board[column][row + 1].getPiece().getTeam().equals("b")) {
                    moves.add(right);
                    //System.out.println(moves);
                }
            }
            //moving diagonal and upwards
            if(column>0 && row <7) {
                if(board[column-1][row+1].getPiece() == null || board[column - 1][row + 1].getPiece().getTeam().equals("b")) {
                    moves.add(diagFR);
                    //System.out.println(moves);
                }
            }
            if(column>0 && row>0) {
                if(board[column-1][row-1].getPiece() == null || board[column - 1][row - 1].getPiece().getTeam().equals("b")) {
                    moves.add(diagFL);
                    //System.out.println(moves);
                }
            }


            if(column != 7 && row !=0) {
                if(board[column+1][row-1].getPiece() == null || board[column + 1][row - 1].getPiece().getTeam().equals("b")) {
                    moves.add(diagBL);
                    //System.out.println(moves);
                }
            }

            if(column!=7 && row !=7) {
                if(board[column+1][row+1].getPiece() == null || board[column + 1][row + 1].getPiece().getTeam().equals("b")) {
                    moves.add(diagBR);
                    //System.out.println(moves);
                }
            }

        }else {

            if(column>0) {
                if(board[column-1][row].getPiece() == null || board[column - 1][row].getPiece().getTeam().equals("w")){
                    moves.add(forward);
                    //System.out.println(moves);
                }
            }
            if(column<7) {
                if(board[column+1][row].getPiece() == null || board[column + 1][row].getPiece().getTeam().equals("w")){
                    moves.add(backward);
                    //System.out.println(moves);
                }
            }

            if(row>0) {
                if(board[column][row-1].getPiece() == null || board[column][row - 1].getPiece().getTeam().equals("w")) {
                    moves.add(left);
                    //System.out.println(moves);
                }
            }
            if(row<7) {
                if(board[column][row+1].getPiece() == null || board[column][row + 1].getPiece().getTeam().equals("w")) {
                    moves.add(right);
                    //System.out.println(moves);
                }
            }
            if(column>0 && row <7) {
                if(board[column-1][row+1].getPiece() == null || board[column - 1][row + 1].getPiece().getTeam().equals("w")) {
                    moves.add(diagFR);
                    //System.out.println(moves);
                }
            }
            if(column>0 && row>0) {
                if(board[column-1][row-1].getPiece() == null || board[column - 1][row - 1].getPiece().getTeam().equals("w")) {
                    moves.add(diagFL);
                    //System.out.println(moves);
                }
            }

            if(column<7 && row >0) {
                if(board[column+1][row-1].getPiece() == null || board[column + 1][row - 1].getPiece().getTeam().equals("w")) {
                    moves.add(diagBL);
                    //System.out.println(moves);
                }
            }
            if(column<7 && row <7) {
                if(board[column+1][row+1].getPiece() == null || board[column + 1][row + 1].getPiece().getTeam().equals("w")) {
                    moves.add(diagBR);
                    //System.out.println(moves);
                }
            }

        }
        //System.out.println(moves);
        return moves;
    }
}