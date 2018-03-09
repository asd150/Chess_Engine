package board;
/**
 * @author Arthkumar Desai
 * */

public class Tile {

    public Piece piece = null;
    //checks if the piece is on the tile
    private String color;
    //Black or white tile
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void nextMoves(int row, int column){
        if(piece!=null){
            this.piece.row=row;
            this.piece.column=column;
        }
    }

    //shows the piece with team + type or blank/##
    public String fillContents() {
        if(piece == null) {
            if(color.equals("w")) {
                return "   ";
            }else return "## ";
        }else return piece.team + piece.getType() + " ";
    }


}
