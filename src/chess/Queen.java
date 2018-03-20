/**
 * @author Roman Stashchyshyn
 * @author Arthkumar Desai
 */
package chess;
import java.util.ArrayList;

/**
 * Class for Queen Piece and its movements.
 */
public class Queen extends Piece {

    public Queen(String team) {
        super("Q");
        this.team = team;
    }

    /**
     *
     * @param board
     * @return moves -- returns arrayList of all movements possible for queen piece.
     */

    public ArrayList<String> movePiece(Tile[][] board) {

        ArrayList<String> moves = new ArrayList<String>();

        int right = row+1;
        int left = row-1;
        int up = column-1;
        int down = column+1;

        boolean upMax = false;
        boolean downMax = false;
        boolean rightMax = false;
        boolean leftMax = false;
        boolean upRightMax = false;
        boolean downRightMax = false;
        boolean upLeftMax = false;
        boolean downLeftMax = false;


        if(team.equals("w")) {

            while(down<8 && !downMax) {
                if(board[down][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    down++;
                    //System.out.println(moves);
                }else if(board[down][row].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    downMax=true;
                    //System.out.println(moves);
                }else {
                    downMax=true;
                }
            }
            while(up>-1 && !upMax) {

                if(board[up][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    up--;
                    //System.out.println(moves);
                }else if(board[up][row].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    upMax=true;
                }else {
                    upMax=true;
                }
            }
            while(right<8 && !rightMax) {

                if(board[column][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    right++;
                    //System.out.println(moves);
                }else if(board[column][right].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    rightMax=true;
                    //System.out.println(moves);
                }else {
                    rightMax=true;
                }
            }
            while(left>-1 && !leftMax) {

                if(board[column][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    left--;
                    //System.out.println(moves);
                }else if(board[column][left].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    leftMax=true;
                    //System.out.println(moves);
                }else {
                    leftMax=true;
                }
            }
        }if(team.equals("b")) {

            while(down< 8 && !downMax) {
                if(board[down][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    down++;
                    //System.out.println(moves);
                }else if(board[down][row].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(down,row);
                    moves.add(move);
                    downMax=true;
                    //System.out.println(moves);
                }else {
                    downMax=true;
                }
            }
            while(up>-1 && !upMax) {

                if(board[up][row].getPiece()==null) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    up--;
                    //System.out.println(moves);
                }else if(board[up][row].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(up,row);
                    moves.add(move);
                    upMax=true;
                    //System.out.println(moves);
                }else {
                    upMax=true;
                }
            }
            while(right<8 && !rightMax) {

                if(board[column][right].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    right++;
                    //System.out.println(moves);
                }else if(board[column][right].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(column,right);
                    moves.add(move);
                    rightMax=true;
                    //System.out.println(moves);
                }else {
                    rightMax=true;
                }
            }
            while(left>-1 && !leftMax) {

                if(board[column][left].getPiece()==null) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    left--;
                    //System.out.println(moves);
                }else if(board[column][left].getPiece().getTeam().equals("w")) {
                    String move = "";
                    move = convertMove(column,left);
                    moves.add(move);
                    leftMax=true;
                    //System.out.println(moves);
                }else {
                    leftMax=true;
                }
            }
        }
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

                if(board[up][right].getPiece()==null) {
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
                    //System.out.println(moves);
                }else if(board[up][left].getPiece().getTeam().equals("b")) {
                    String move = "";
                    move = convertMove(up,left);
                    moves.add(move);
                    upLeftMax=true;
                    //System.out.println(moves);
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
                    upLeftMax=true;
                    //System.out.println(moves);
                }else {
                    upLeftMax=true;
                }
            }


        }

        //System.out.println(moves);
        return moves;

    }

}