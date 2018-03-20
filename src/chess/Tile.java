/**
 * @author Roman Stashchyshyn
 * @author Arthkumar Desai
 */
package chess;

/**
 * Tile class that fills board with Tiles in array
 */
public class Tile {

    private Piece piece = null;
    private String tileColor;

    /**
     * Constructor
     */
    public Tile() {

    }

    /**
     * sets the correct next moves
     * @param row
     * @param column
     */
    public void setNextMoves(int row, int column) {
        if(piece!=null) {
            this.piece.column = column;
            this.piece.row = row;
        }
    }

    /**
     * setter for Tile
     * @param piece
     */
    public void setTile(Piece piece) {
        this.piece = piece;

    }

    /**
     * getter for Piece on the tile
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Setter for the color of the tile
     * @param tileColor
     */
    public void setTileColor(String tileColor) {
        this.tileColor = tileColor;
    }

    /**
     * gets the all info for the Tile in array. If there is no piece on the tile it returns the
     * correct ascii art, otherwise it returns a the piece on the tile
     * @return
     */
    public String getSymbol() {
        if(piece == null) {
            if(tileColor.equals("w")) {
                return "   ";
            }else {
                return "## ";
            }
        }else {
            return piece.team + piece.getType() + " ";
        }
    }

}