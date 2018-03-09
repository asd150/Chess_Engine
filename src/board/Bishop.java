package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */


public class Bishop extends Piece{

    public Bishop(String team){
        super("B");
        this.team = team;
    }

    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        return null;
    }
}
