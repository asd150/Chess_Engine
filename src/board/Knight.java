package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */
public class Knight extends Piece {

    public Knight(String team){

        super("N");
        this.team=team;
    }

    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        return null;
    }
}
