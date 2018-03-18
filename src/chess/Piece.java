package chess;
/**
 * 2 player Chess
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn*/
import java.util.*;

public abstract class Piece {

    public String kind;
    public String team;
    public  int column;
    public  int row;
    public boolean moved = true;


    public Piece(String kind) {
        this.kind = kind;
    }

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

    public String getType() {
        return kind;
    }

    public String getTeam() {
        return team;
    }

    public boolean hasNotMoved() {
        return this.moved;
    }

    public void setMoved(boolean bool) {
        this.moved = bool;
    }



}