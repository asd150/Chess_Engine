/**
 * @author Roman Stashchyshyn
 * @author Arthkumar Desai
 */

package chess;
import java.util.ArrayList;

/**
 * Class for Pawn. Takes care of movement and kill.
 */
public class Pawn extends Piece{

    boolean hasMoved = false;


    public Pawn(String team) {
        super("P");
        this.team = team;
    }
    /**
     *
     * @param board
     * @return moves -- arraylist with movements for the piece
     */
    public ArrayList<String> movePiece(Tile[][] board) {


        ArrayList<String> moves = new ArrayList<String>();

        //boolean for checking if the piece has been moved already or not (can pawn move 2 steps or only 1)
        if(hasNotMoved()) {
            hasMoved = false;
        }


        if(team.equals("w")) {

            String position1;
            String position2;

            position1 = convertMove(column-1,row);
            position2 = convertMove(column-2,row);
            if(!hasMoved) {
                if(board[column-1][row].getPiece() ==null && board[column-2][row].getPiece() == null) {
                    moves.add(position2);
                    moves.add(position1);
                    //System.out.println(moves);
                }else if(board[column-1][row].getPiece() ==null) {
                    moves.add(position1);
                    //System.out.println(moves);
                }
                //if the move is invalid then the boolean flag might be set incorrectly
                hasMoved = true;
            }else if(board[column-1][row].getPiece() ==null){
                moves.add(position1);
                //System.out.println(moves);
            }
            if(row == 0 ) {
                String position4;

                if(board[column-1][row+1].getPiece() != null && board[column-1][row+1].getPiece().getTeam()!="w") {
                    position4 = convertMove(column-1, row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }else if(row == 7 ) {
                String position3;
                if(board[column-1][row-1].getPiece() != null && board[column-1][row-1].getPiece().getTeam()!="w") {
                    position3 = convertMove(column-1, row-1);
                    moves.add(position3);
                    //System.out.println(moves);
                }
            }else {
                String position3;
                String position4;
                if(board[column-1][row-1].getPiece() != null && board[column-1][row-1].getPiece().getTeam()!= "w" ) {
                    position3 = convertMove(column-1, row-1);
                    moves.add(position3);
                    //System.out.println(moves);
                }if(board[column-1][row+1].getPiece() != null && board[column-1][row+1].getPiece().getTeam()!="w") {
                    position4 = convertMove(column-1, row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }
        }else {
            String position1;
            String position2;

            position1 = convertMove(column+1,row);
            position2 = convertMove(column+2,row);
            if(!hasMoved) {
                if(board[column+1][row].getPiece() ==null && board[column+1][row].getPiece() == null) {
                    moves.add(position2);
                    moves.add(position1);
                    //System.out.println(moves);
                }else if(board[column+1][row].getPiece() ==null) {
                    moves.add(position1);
                    //System.out.println(moves);
                }
                //if the move is invalid then the boolean flag might be set incorrectly
                hasMoved = true;
            }else if(board[column+1][row].getPiece() ==null){
                moves.add(position1);
                //System.out.println(moves);
            }
            if(row == 0 ) {
                String position4;

                if(board[column+1][row+1].getPiece() != null && board[column+1][row+1].getPiece().getTeam()!="b") {
                    position4 = convertMove(column-1, row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }else if(row == 7) {
                String position3;

                if(board[column+1][row-1].getPiece() != null && board[column+1][row-1].getPiece().getTeam()!="b") {
                    position3 = convertMove(column-1, row-1);
                    moves.add(position3);
                    //System.out.println(moves);
                }
            }else {
                String position3;
                String position4;

                if(board[column+1][row-1].getPiece() != null && board[column+1][row-1].getPiece().getTeam()!="b") {
                    position3 = convertMove(column+1, row-1);
                    moves.add(position3);
                    //System.out.println(moves);
                }if(board[column+1][row+1].getPiece() != null && board[column+1][row+1].getPiece().getTeam()!="b") {
                    position4 = convertMove(column+1, row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }
        }
        //System.out.println(moves);
        return moves;
    }
}
