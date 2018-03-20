/**
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn
 */
package chess;

import java.util.*;
/**
 * Abstract class for piece that is used in all Piece types
 */
public abstract class Piece {

    public String kind;
    public String team;
    public  int column;
    public  int row;
    public boolean moved = true;

    /**
     * Constructor
     */
    public Piece(String kind) {
        this.kind = kind;
    }

    /**
     *
     * @param initRow
     * @param initColumn
     * @return end -- Converts the move to what the user sees/inputs in the 2D array
     * displaying the board and returns this
     */
    public String convertMove(int initRow, int initColumn) {

        String end;
        StringBuilder sb = new StringBuilder();
        int endRow = 8 - initRow;
        char endColumn;
        if(initColumn == 0) {
            endColumn = 'a';
        }else if(initColumn == 1) {
            endColumn = 'b';
        }else if(initColumn == 2) {
            endColumn = 'c';
        }else if(initColumn == 3) {
            endColumn = 'd';
        }else if(initColumn == 4) {
            endColumn = 'e';
        }else if(initColumn == 5) {
            endColumn = 'f';
        }else if(initColumn == 6) {
            endColumn = 'g';
        }else{
            endColumn = 'h';
        }

        sb.append(endColumn);
        sb.append(endRow);
        end = sb.toString();

        //System.out.println(end);
        return end;
    }

    public abstract ArrayList<String> movePiece(Tile[][] board);
    /**
     * Getter for type of the piece
     */
    public String getType() {
        return kind;
    }

    /**
     * Getter for the team of the piece
     * @return
     */
    public String getTeam() {
        return team;
    }

    /**
     * Need this since many actions on the board are dependent on whether the piece has moved or not
     * @return
     */
    public boolean hasNotMoved() {
        return this.moved;
    }

    public void setMoved(boolean bool) {
        this.moved = bool;
    }



}