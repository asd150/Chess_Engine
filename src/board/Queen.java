package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */
public class Queen extends Piece {

    public Queen(String team){
        super("Q");
        this.team = team;
    }

    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        return null;
    }
}
