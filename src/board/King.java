package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */
public class King extends Piece {
    public  King(String team){
        super("K");
        this.team=team;
    }

    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        return null;
    }
}
