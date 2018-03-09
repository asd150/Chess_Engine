package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */
public class Rook extends Piece {
    public Rook(String team){
        super("R");
        this.team=team;}

    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        return null;
    }
}
