/**
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn
 */
package chess;

import java.util.ArrayList;

/**
 * Takes care of all of the functions of the board
 */
public class Board {

    private final static int length = 8;
    private final static int width = 8;
    private static boolean LBRMoved = false;
    private static boolean LWRMoved = false;
    private static boolean RBRMoved = false;
    private static boolean RWRMoved = false;
    private static boolean BQCastle = false;
    private static boolean BKCastle = false;
    private static boolean WQCastle = false;
    private static boolean WKCastle = false;
    private static boolean WKingMoved = false;
    private static boolean BKingMoved = false;


    public static Tile[][] board = new Tile[length][width];

    boolean inCheck = false;
    String kingPosB = "e8";
    String kingPosW = "e1";
    Piece fromCheck;

    /**
     * display the board and print it out based off of tile /piece objects
     */
    public Board () {

        for(int i = 0; i<length; i++) {
            for(int j = 0; j<width; j++) {
                Tile square = new Tile();
                //Black back row
                if(i == 0) {
                    //Rook
                    if(j==0 || j==7) {
                        Piece rook = new Rook("b");
                        square.setTile(rook);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Knight
                    }else if(j==1 || j==6) {
                        Piece knight = new Knight("b");
                        square.setTile(knight);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Bishop
                    }else if(j==2 || j==5) {
                        Piece bishop = new Bishop("b");
                        square.setTile(bishop);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Queen
                    }else if(j==3) {
                        Piece queen = new Queen("b");
                        square.setTile(queen);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //King
                    }else{
                        Piece king = new King("b");
                        square.setTile(king);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                    }
                    //Black pawn row
                }else if(i == 1) {
                    Piece pawn = new Pawn("b");
                    square.setTile(pawn);
                    square.setNextMoves(j,i);
                    board[i][j]= square;

                    //White pawn row
                }else if(i == 6) {
                    Piece pawn = new Pawn("w");
                    square.setTile(pawn);
                    square.setNextMoves(j,i);
                    board[i][j]= square;

                    //White
                }else if(i == 7) {
                    //Rook
                    if(j==0 || j==7) {
                        Piece rook = new Rook("w");
                        square.setTile(rook);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Knight
                    }else if(j==1 || j==6) {
                        Piece knight = new Knight("w");
                        square.setTile(knight);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Bishop
                    }else if(j==2 || j==5) {
                        Piece bishop = new Bishop("w");
                        square.setTile(bishop);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //Queen
                    }else if(j==3) {
                        Piece queen = new Queen("w");
                        square.setTile(queen);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                        //King
                    }else{
                        Piece king = new King("w");
                        square.setTile(king);
                        square.setNextMoves(j,i);
                        board[i][j]= square;

                    }
                }if(i % 2 == 0) {
                    //Black square
                    if(j % 2 == 1) {
                        square.setTileColor("b");
                        board[i][j]= square;
                        continue;
                        //White square
                    }else {
                        square.setTileColor("w");
                        board[i][j]= square;
                        continue;
                    }
                }if(i % 2 == 1) {
                    //White square
                    if(j % 2 == 1) {
                        square.setTileColor("w");
                        board[i][j]= square;
                        //Black square
                    }else {
                        square.setTileColor("b");
                        board[i][j]= square;
                    }
                }
            }
        }

    }

    /**
     *
     * @param from starting point
     * @param to ending point
     * @param whitesMove boolean if whites moves
     * @param switchType is it pawn promotion or not
     * @return returns a boolean which determines if the moves is valid based off of input
     */
    public boolean createMove(String from, String to, boolean whitesMove, String switchType) {

        ArrayList<String> possibleMoves = null;
        ArrayList<String> possibleCheck = null;
        ArrayList<String> movedOutOfCheck = null;
        Piece newPos  = null;
        Piece swapPiece = null;
        boolean movingKing = false;

        char[] col1 = to.substring(0,1).toCharArray();
        String row1 = to.substring(1);
        int numRow1 = Math.abs(Integer.parseInt(row1) - 8);
        int numCol1 = Character.getNumericValue(col1[0]) - 10;
        char[] col2 = from.substring(0,1).toCharArray();
        String row2 = from.substring(1);
        int numRow2 = Math.abs(Integer.parseInt(row2) - 8);
        int numCol2 = Character.getNumericValue(col2[0]) - 10;
        Piece piece = getPiece(from);
        Piece toPiece = getPiece(to);
        board[numRow1][numCol1].setTile(toPiece);
        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);



        if(piece==null) {
            board[numRow2][numCol2].setTile(piece);
            board[numRow1][numCol1].setTile(toPiece);
            return false;
        }

        if(piece.getType().equals("K")) {
            if(piece.getTeam().equals("w")) {
                kingPosW = to;
                movingKing = true;
            }else {
                kingPosB = to;
                movingKing = true;
            }
        }
        possibleMoves = piece.movePiece(board);
        if(inCheck) {
            if((piece.getTeam().equals("w") && whitesMove) || (piece.getTeam().equals("b") && !whitesMove)) {
                if(possibleMoves.contains(to)) {
                    if(switchType != null && piece.getType().equals("P")) {
                        switch (switchType) {
                            case "R":
                                piece = new Rook(piece.getTeam());
                                break;
                            case "B":
                                piece = new Bishop(piece.getTeam());
                                break;
                            case "N":
                                piece = new Knight(piece.getTeam());
                                break;
                            case "Q":
                                piece = new Queen(piece.getTeam());
                                break;
                        }
                    }


                    if(piece.getType().equals("P") && piece.hasNotMoved()) {
                        piece.setMoved(false);
                    }else if(piece.getType().equals("R")) {

                        switch (from) {
                            case "a1":
                                LWRMoved = true;
                                break;
                            case "h1":
                                RWRMoved = true;
                                break;
                            case "a8":
                                LBRMoved = true;
                                break;
                            case "h8":
                                RBRMoved = true;
                                break;
                        }

                    }else if(piece.getType().equals("K")) {

                        if(from.equals("e1")) {
                            WKingMoved = true;
                        }else if(from.equals("e8")) {
                            BKingMoved = true;
                        }
                    }
                    board[numRow1][numCol1].setTile(piece);
                    board[numRow1][numCol1].setNextMoves(numCol1,numRow1);

                }else {
                    board[numRow2][numCol2].setTile(piece);
                    if(movingKing) {
                        if(whitesMove) {
                            kingPosW = from;
                            return false;
                        }else {
                            kingPosB = from;
                            return false;
                        }
                    }else {
                        return false;

                    }
                }
            }else{
                board[numRow2][numCol2].setTile(piece);
                if(movingKing) {
                    if(whitesMove) {
                        kingPosW = from;
                        return false;
                    }else {
                        kingPosB = from;
                        return false;
                    }
                }else {
                    return false;

                }
            }
            movedOutOfCheck = fromCheck.movePiece(board);
            String checkPos = convertMove(fromCheck.column, fromCheck.row);


            if(!to.equals(checkPos)) {
                if(whitesMove) {
                    if(movedOutOfCheck.contains(kingPosW)) {
                        board[numRow2][numCol2].setTile(piece);
                        board[numRow1][numCol1].setTile(toPiece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        board[numRow2][numCol2].setNextMoves(numCol2,numRow2);
                        return false;
                    }
                }else {
                    if(movedOutOfCheck.contains(kingPosB)) {
                        board[numRow2][numCol2].setTile(piece);
                        board[numRow1][numCol1].setTile(toPiece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        board[numRow2][numCol2].setNextMoves(numCol2,numRow2);
                        return false;
                    }
                }
            }

        }inCheck = false;
        if((piece.getTeam().equals("w") && whitesMove) || (piece.getTeam().equals("b") && !whitesMove)) {
            if(possibleMoves.contains(to) || castle(to, from)) {
                if(!intoCheck(numRow1, numCol1, whitesMove)) {

                    if(switchType != null && piece.getType().equals("P")) {
                        switch (switchType) {
                            case "R":
                                piece = new Rook(piece.getTeam());
                                break;
                            case "B":
                                piece = new Bishop(piece.getTeam());
                                break;
                            case "N":
                                piece = new Knight(piece.getTeam());
                                break;
                            case "Q":
                                piece = new Queen(piece.getTeam());
                                break;
                        }
                    }
                    if(WQCastle) {
                        board[numRow1][numCol1].setTile(piece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        Piece moveRook = board[7][0].getPiece();
                        board[7][0].setTile(null);
                        board[7][3].setTile(moveRook);
                        WQCastle = false;

                    }else if(WKCastle) {
                        board[numRow1][numCol1].setTile(piece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        Piece moveRook = board[7][7].getPiece();
                        board[7][7].setTile(null);
                        board[7][5].setTile(moveRook);
                        WKCastle = false;

                    }else if(BQCastle) {
                        board[numRow1][numCol1].setTile(piece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        Piece moveRook = board[0][0].getPiece();
                        board[0][0].setTile(null);
                        board[0][3].setTile(moveRook);
                        BQCastle = false;

                    }else if(BKCastle) {
                        board[numRow1][numCol1].setTile(piece);
                        board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                        Piece moveRook = board[7][7].getPiece();
                        board[7][7].setTile(null);
                        board[7][5].setTile(moveRook);
                        BKCastle = false;
                    }

                    if(piece.getType().equals("P") && piece.hasNotMoved()) {
                        piece.setMoved(false);
                    }else if(piece.getType().equals("R")) {
                        switch (from) {
                            case "a1":
                                LWRMoved = true;
                                break;
                            case "h1":
                                RWRMoved = true;
                                break;
                            case "a8":
                                LBRMoved = true;
                                break;
                            case "h8":
                                RBRMoved = true;
                                break;
                        }

                    }else if(piece.getType().equals("K")) {
                        if(from.equals("e1")) {
                            WKingMoved = true;
                        }else if(from.equals("e8")) {
                            BKingMoved = true;
                        }
                    }

                    board[numRow1][numCol1].setTile(piece);
                    board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                    newPos = board[numRow1][numCol1].getPiece();
                    possibleCheck = newPos.movePiece(board);
                    inCheck(possibleCheck,newPos, whitesMove);
                    return true;

                }else {
                    board[numRow2][numCol2].setTile(piece);
                    board[numRow1][numCol1].setTile(toPiece);
                    board[numRow1][numCol1].setNextMoves(numCol1,numRow1);
                    board[numRow2][numCol2].setNextMoves(numCol2,numRow2);

                    if(movingKing) {
                        if(whitesMove) {
                            kingPosW = from;
                            return false;
                        }else {
                            kingPosB = from;
                            return false;
                        }
                    }else {
                        return false;
                    }
                }

            }else {
                board[numRow2][numCol2].setTile(piece);
                if(movingKing) {
                    if(whitesMove) {
                        kingPosW = from;
                        return false;
                    }else {
                        kingPosB = from;
                        return false;
                    }
                }else {
                    return false;

                }
            }
        }else {
            board[numRow2][numCol2].setTile(piece);
            if(movingKing) {
                if(whitesMove) {
                    kingPosW = from;
                    return false;
                }else {
                    kingPosB = from;
                    return false;
                }
            }else {
                return false;

            }
        }

    }

    /**
     * Checks if a castle is allowed to be used
     * @param to starting
     * @param from ending
     * @return boolean that makes tells us if it is or isnt valid
     */
    public boolean castle(String to, String from) {

        String BQCSpot = "c8";
        String BKCSpot = "g8";
        String WKCSpot = "g1";
        String WQCSpot = "c1";

        if(from.equals("e1")) {
            if(to.equals(WQCSpot)) {
                if(LWRMoved || WKingMoved) {

                    return false;
                }else {
                    if(board[7][1].getPiece() != null || board[7][2].getPiece() != null || board[7][3].getPiece() != null) {
                        return false;
                    }else {
                        WQCastle = true;
                        return true;
                    }
                }
            }else if(to.equals(WKCSpot)) {
                if(RWRMoved || WKingMoved) {
                    return false;
                }else {
                    if(board[7][6].getPiece() != null || board[7][5].getPiece() != null) {
                        return false;
                    }else {
                        WKCastle = true;
                        return true;
                    }
                }

            }else {
                return false;
            }
        }else if(from.equals("e8")) {
            if(to.equals(BQCSpot)) {
                if(LBRMoved || BKingMoved) {
                    return false;
                }else {
                    if(board[0][1].getPiece() != null || board[0][2].getPiece() != null || board[0][3].getPiece() != null) {
                        return false;
                    }else {
                        BQCastle = true;
                        return true;
                    }
                }
            }else if(to.equals(BKCSpot)) {
                if(RBRMoved || BKingMoved) {
                    return false;
                }else {
                    if(board[0][6].getPiece() != null || board[0][5].getPiece() != null) {
                        return false;
                    }else {
                        BKCastle = true;
                        return true;
                    }
                }

            }else {
                return false;
            }
        }



        return false;
    }

    /**
     * Determines if check mate is occuring
     * @param whitesMove whites move or not
     * @return boolean return type tells us whether it is or not
     */
    public boolean checkMate(boolean whitesMove) {
        Piece kingTempW = new King("w");
        Piece kingTempB = new King("b");
        Piece temp = null;
        ArrayList<String> kingMoves = null;
        ArrayList<String> individualPos = new ArrayList<String>();
        ArrayList<Piece> piecesW = new ArrayList<Piece>();
        ArrayList<Piece> piecesB = new ArrayList<Piece>();
        Piece checkKnightW = new Knight("w");
        piecesW.add(checkKnightW);
        Piece checkKnightB = new Knight("b");
        piecesB.add(checkKnightB);
        Piece checkBishopW = new Bishop("w");
        piecesW.add(checkBishopW);
        Piece checkBishopB = new Bishop("b");
        piecesB.add(checkBishopB);
        Piece checkRookW = new Rook("w");
        piecesW.add(checkRookW);
        Piece checkRookB = new Rook("b");
        piecesB.add(checkRookB);
        Piece checkQueenW = new Queen("w");
        piecesW.add(checkQueenW);
        Piece checkQueenB = new Queen("b");
        piecesB.add(checkQueenB);
        Piece checkKingW = new King("w");
        piecesW.add(checkKingW);
        Piece checkKingB = new King("b");
        piecesB.add(checkKingB);
        char[] col1;
        String row1;
        String type;

        int numRow1;
        int numCol1;
        boolean kingCantMove = false;


        if(whitesMove) {
            char[] kingCol = kingPosW.substring(0,1).toCharArray();
            String kingRow = kingPosW.substring(1);
            int kCol = Math.abs(Integer.parseInt(kingRow) - 8);
            int kRow = Character.getNumericValue(kingCol[0]) - 10;
            kingTempW = board[kCol][kRow].getPiece();
            kingMoves = kingTempW.movePiece(board);



            for(int i = 0; i < kingMoves.size(); i++) {
                col1 = kingMoves.get(i).substring(0,1).toCharArray();
                row1 = kingMoves.get(i).substring(1);
                numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                numCol1 = Character.getNumericValue(col1[0]) - 10;

                if(!intoCheck(numRow1,numCol1, whitesMove)) {
                    return false;
                }else {
                    kingMoves.remove(i);
                }
            }

            board[kCol][kRow].setTile(kingTempW);
            board[kCol][kRow].setNextMoves(kRow, kCol);

            if(kingMoves.size() == 0) {
                for(int i = 0; i<piecesW.size(); i++) {


                    board[kCol][kRow].setTile(piecesW.get(i));
                    board[kCol][kRow].setNextMoves(kRow,kCol);

                    temp = board[kCol][kRow].getPiece();
                    individualPos = temp.movePiece(board);

                    type = piecesW.get(i).getType();

                    for(int j = 0; j<individualPos.size(); j++) {

                        col1 = individualPos.get(j).substring(0,1).toCharArray();
                        row1 = individualPos.get(j).substring(1);
                        numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                        numCol1 = Character.getNumericValue(col1[0]) - 10;


                        if(board[numRow1][numCol1].getPiece() != null) {
                            if(board[numRow1][numCol1].getPiece().getType().equals(type)) {
                                board[kCol][kRow].setTile(kingTempW);
                                board[kCol][kRow].setNextMoves(kRow,kCol);

                                kingCantMove = helper(type,numRow1,numCol1,kCol,kRow,whitesMove);
                            }
                        }

                    }
                    individualPos = null;
                }
            }
        }else {
            char[] kingCol = kingPosB.substring(0,1).toCharArray();
            String kingRow = kingPosB.substring(1);
            int kCol = Math.abs(Integer.parseInt(kingRow) - 8);
            int kRow = Character.getNumericValue(kingCol[0]) - 10;
            kingTempB = board[kCol][kRow].getPiece();
            kingMoves = kingTempB.movePiece(board);



            for(int i = 0; i < kingMoves.size(); i++) {
                col1 = kingMoves.get(i).substring(0,1).toCharArray();
                row1 = kingMoves.get(i).substring(1);
                numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                numCol1 = Character.getNumericValue(col1[0]) - 10;

                if(!intoCheck(numRow1,numCol1, whitesMove)) {
                    return false;
                }else {
                    kingMoves.remove(i);
                }
            }

            board[kCol][kRow].setTile(kingTempB);
            board[kCol][kRow].setNextMoves(kRow, kCol);

            if(kingMoves.size() == 0) {
                for(int i = 0; i<piecesB.size(); i++) {


                    board[kCol][kRow].setTile(piecesB.get(i));
                    board[kCol][kRow].setNextMoves(kRow,kCol);

                    temp = board[kCol][kRow].getPiece();
                    individualPos = temp.movePiece(board);

                    type = piecesB.get(i).getType();

                    for(int j = 0; j<individualPos.size(); j++) {

                        col1 = individualPos.get(j).substring(0,1).toCharArray();
                        row1 = individualPos.get(j).substring(1);
                        numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                        numCol1 = Character.getNumericValue(col1[0]) - 10;


                        if(board[numRow1][numCol1].getPiece() != null) {
                            if(board[numRow1][numCol1].getPiece().getType() == type) {
                                board[kCol][kRow].setTile(kingTempB);
                                board[kCol][kRow].setNextMoves(kRow,kCol);

                                kingCantMove = helper(type,numRow1,numCol1,kCol,kRow,whitesMove);
                            }
                        }

                    }
                    individualPos = null;
                }
            }
        }
        if(kingCantMove) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param initRow initial row
     * @param initColumn initial column
     * @return Converts the move to what the user sees/inputs in the 2D array
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

    /**This is a helper for the check mate that returns whether a king
     * can be protected/defended
     *
     * @param type the type of the piece
     * @param row row of piece
     * @param col column of piece
     * @param kingRow where the king is
     * @param kingCol same as above except column
     * @param whitesMove is it whitesmoves?
     * @return
     */
    public boolean helper(String type, int row, int col,int kingRow, int kingCol, boolean whitesMove) {

        ArrayList<String> indPotentialMoves = null;
        ArrayList<String> potentialMoves = new ArrayList<String>();
        Piece temp = null;
        boolean checkFromLeft, checkFromRight, checkFromUp, checkFromDown, checkFromDiagUL, checkFromDiagUR, checkFromDiagBL, checkFromDiagBR;
        checkFromLeft = false;
        checkFromRight = false;
        checkFromUp = false;
        checkFromDown = false;
        checkFromDiagUL = false;
        checkFromDiagUR = false;
        checkFromDiagBL = false;
        checkFromDiagBR = false;


        if(kingCol == col) {
            if(kingRow > row) {
                checkFromUp = true;
            }else {
                checkFromDown = true;
            }
        }else if(kingRow == row) {
            if(kingCol > col) {
                checkFromLeft = true;
            }else {
                checkFromRight = true;
            }
        }else if(kingRow > row && kingCol > col) {
            checkFromDiagUL = true;
        }else if(kingRow > row && kingCol < col) {
            checkFromDiagUR = true;
        }else if(kingRow < row && kingCol > col) {
            checkFromDiagBL = true;
        }else if(kingRow < row && kingCol < col) {
            checkFromDiagBR = true;
        }

        for(int i = 0; i<8; i++) {
            for(int j = 0; j<8; j++) {
                if(whitesMove) {
                    if(board[i][j].getPiece() != null) {
                        if(board[i][j].getPiece().getTeam().equals("w") && board[i][j].getPiece().getType() != "K") {
                            indPotentialMoves = board[i][j].getPiece().movePiece(board);
                            for(int k = 0; k < indPotentialMoves.size(); k++) {
                                potentialMoves.add(indPotentialMoves.get(k));
                            }
                        }
                    }
                }else {
                    if(board[i][j].getPiece() != null) {
                        if(board[i][j].getPiece().getTeam().equals("b") && board[i][j].getPiece().getType() != "K") {
                            indPotentialMoves = board[i][j].getPiece().movePiece(board);
                            for(int k = 0; k < indPotentialMoves.size(); k++) {
                                potentialMoves.add(indPotentialMoves.get(k));
                            }
                        }
                    }
                }

            }
        }
        switch(type) {
            case "R":
                if(potentialMoves.contains(convertMove(row, col))) {
                    return false;
                }else {
                    if(checkFromDown) {
                        for(int i = row-1; i!=kingRow; i--) {
                            if(potentialMoves.contains(convertMove(i,col))) {
                                return false;
                            }
                        }
                        return true;
                    }else if(checkFromUp) {
                        for(int i = row+1; i!=kingRow; i++) {
                            if(potentialMoves.contains(convertMove(i,col))) {
                                return false;
                            }
                        }
                        return true;

                    }else if(checkFromRight) {
                        for(int i = col-1; i!= kingCol; i--) {
                            if(potentialMoves.contains(convertMove(row,i))) {
                                return false;
                            }
                        }
                        return true;

                    }else if(checkFromLeft) {
                        for(int i = col+1; i!= kingCol; i++) {
                            if(potentialMoves.contains(convertMove(row,i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            case "B":
                if(potentialMoves.contains(convertMove(row, col))) {
                    return false;
                }else {
                    if(checkFromDiagUL) {
                        int i,j;
                        i = row+1;
                        j = col+1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }else {
                                i++;
                                j++;
                            }
                        }
                        return true;
                    }else if(checkFromDiagUR) {
                        int i,j;
                        i = row+1;
                        j = col-1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i++;
                            j--;
                        }
                        return true;
                    }else if(checkFromDiagBL) {
                        int i,j;
                        i = row-1;
                        j = col+1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i--;
                            j++;
                        }
                        return true;

                    }else if(checkFromDiagBR) {
                        int i,j;
                        i = row-1;
                        j = col-1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i--;
                            j--;
                        }
                        return true;
                    }
                }

            case "Q":

                if(potentialMoves.contains(convertMove(row, col))) {
                    return false;
                }else {
                    if(checkFromDown) {
                        for(int i = row-1; i!=kingRow; i--) {
                            if(potentialMoves.contains(convertMove(i,col))) {
                                return false;
                            }
                        }
                        return true;
                    }else if(checkFromUp) {
                        for(int i = row+1; i!=kingRow; i++) {
                            if(potentialMoves.contains(convertMove(i,col))) {
                                return false;
                            }
                        }
                        return true;

                    }else if(checkFromRight) {
                        for(int i = col-1; i!= kingCol; i--) {
                            if(potentialMoves.contains(convertMove(row,i))) {
                                return false;
                            }
                        }
                        return true;

                    }else if(checkFromLeft) {
                        for(int i = col+1; i!= kingCol; i++) {
                            if(potentialMoves.contains(convertMove(row,i))) {
                                return false;
                            }
                        }
                        return true;
                    }else if(checkFromDiagUL) {
                        int i,j;
                        i = row+1;
                        j = col+1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }else {
                                i++;
                                j++;
                            }
                        }
                        return true;
                    }else if(checkFromDiagUR) {
                        int i,j;
                        i = row+1;
                        j = col-1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i++;
                            j--;
                        }
                        return true;
                    }else if(checkFromDiagBL) {
                        int i,j;
                        i = row-1;
                        j = col+1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i--;
                            j++;
                        }
                        return true;

                    }else if(checkFromDiagBR) {
                        int i,j;
                        i = row-1;
                        j = col-1;
                        while(i != kingRow && j != kingCol) {
                            if(potentialMoves.contains(convertMove(i,j))) {
                                return false;
                            }
                            i--;
                            j--;
                        }
                        return true;
                    }
                }

            case "N":

                return !potentialMoves.contains(convertMove(row, col));

            default:

        }
        return false;
    }

    /**Checks to see if a move is going to put the King into check
     *
     * @param row row of the movement
     * @param col column of the movement
     * @param whitesMoves is it whites moves?
     * @return boolean
     */
    public boolean intoCheck(int row, int col, boolean whitesMoves) {

        ArrayList<String> individualPos = null;
        ArrayList<Piece> piecesW = new ArrayList<Piece>();
        ArrayList<Piece> piecesB = new ArrayList<Piece>();
        Piece temp = null;
        Piece dummyTempW = new King("w");
        Piece dummyTempB = new King("b");
        Piece kingTempW = new King("w");
        Piece kingTempB = new King("b");

        Piece checkKnightW = new Knight("w");
        piecesW.add(checkKnightW);
        Piece checkKnightB = new Knight("b");
        piecesB.add(checkKnightB);
        Piece checkBishopW = new Bishop("w");
        piecesW.add(checkBishopW);
        Piece checkBishopB = new Bishop("b");
        piecesB.add(checkBishopB);
        Piece checkRookW = new Rook("w");
        piecesW.add(checkRookW);
        Piece checkRookB = new Rook("b");
        piecesB.add(checkRookB);
        Piece checkQueenW = new Queen("w");
        piecesW.add(checkQueenW);
        Piece checkQueenB = new Queen("b");
        piecesB.add(checkQueenB);
        Piece checkKingW = new King("w");
        piecesW.add(checkKingW);
        Piece checkKingB = new King("b");
        piecesB.add(checkKingB);


        if(whitesMoves) {

            board[row][col].setTile(dummyTempW);
            board[row][col].setNextMoves(row,col);


            char[] kingCol = kingPosW.substring(0,1).toCharArray();
            String kingRow = kingPosW.substring(1);
            int kCol = Math.abs(Integer.parseInt(kingRow) - 8);
            int kRow = Character.getNumericValue(kingCol[0]) - 10;
            kingTempW = board[kCol][kRow].getPiece();

            for(int i = 0; i<piecesW.size(); i++) {


                board[kCol][kRow].setTile(piecesW.get(i));
                board[kCol][kRow].setNextMoves(kRow,kCol);

                temp = board[kCol][kRow].getPiece();
                individualPos = temp.movePiece(board);

                String type = piecesW.get(i).getType();

                for(int j = 0; j<individualPos.size(); j++) {

                    char[] col1 = individualPos.get(j).substring(0,1).toCharArray();
                    String row1 = individualPos.get(j).substring(1);
                    int numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                    int numCol1 = Character.getNumericValue(col1[0]) - 10;


                    if(board[numRow1][numCol1].getPiece() != null) {
                        if(board[numRow1][numCol1].getPiece().getType().equals(type)) {
                            board[kCol][kRow].setTile(kingTempW);
                            board[kCol][kRow].setNextMoves(kRow,kCol);
                            return true;
                        }
                    }

                }
                board[row][col].setTile(null);
                individualPos = null;
            }
        }else {

            board[row][col].setTile(dummyTempB);
            board[row][col].setNextMoves(row,col);


            char[] kingCol = kingPosB.substring(0,1).toCharArray();
            String kingRow = kingPosB.substring(1);
            int kCol = Math.abs(Integer.parseInt(kingRow) - 8);
            int kRow = Character.getNumericValue(kingCol[0]) - 10;
            kingTempB = board[kCol][kRow].getPiece();

            for(int i = 0; i<piecesB.size(); i++) {


                board[kCol][kRow].setTile(piecesB.get(i));
                board[kCol][kRow].setNextMoves(kRow,kCol);

                temp = board[kCol][kRow].getPiece();
                individualPos = temp.movePiece(board);

                String type = piecesB.get(i).getType();

                for(int j = 0; j<individualPos.size(); j++) {

                    char[] col1 = individualPos.get(j).substring(0,1).toCharArray();
                    String row1 = individualPos.get(j).substring(1);
                    int numRow1 = Math.abs(Integer.parseInt(row1) - 8);
                    int numCol1 = Character.getNumericValue(col1[0]) - 10;

                    if(board[numRow1][numCol1].getPiece() != null) {
                        if(board[numRow1][numCol1].getPiece().getType().equals(type)) {
                            board[kCol][kRow].setTile(kingTempB);
                            board[kCol][kRow].setNextMoves(kRow,kCol);
                            return true;
                        }
                    }

                }
                board[row][col].setTile(null);
                individualPos = null;
            }
        }

        return false;

    }

    /**
     * Determines if actually in check
     * @param moves the movements on the board
     * @param posOfCheck piece that is put into the position of Check
     * @param whitesMove is it whites move?
     */
    public void inCheck(ArrayList<String> moves, Piece posOfCheck, boolean whitesMove) {



        for(int i = 0; i< moves.size(); i++) {
            String square = moves.get(i);
            char[] col1 = square.substring(0,1).toCharArray();
            String row1 = square.substring(1);
            int numRow1 = Math.abs(Integer.parseInt(row1) - 8);
            int numCol1 = Character.getNumericValue(col1[0]) - 10;
            if(board[numRow1][numCol1].getPiece() != null) {
                if(board[numRow1][numCol1].getPiece().kind.equals("K")) {
                    if(!whitesMove) {
                        kingPosW = moves.get(i);
                        inCheck = true;
                        fromCheck = posOfCheck;
                    }else {
                        kingPosB = moves.get(i);
                        inCheck = true;
                        fromCheck = posOfCheck;
                    }
                }
            }

        }

    }

    /**Getter for the piece in a certain position
     *
     * @param location - location of the piece
     * @return the piece inside of the tile
     */
    public Piece getPiece(String location) {

        Piece rtn = null;
        char[] col = location.substring(0,1).toCharArray();
        String row = location.substring(1);
        int numRow = Math.abs(Integer.parseInt(row) - 8);
        int numCol = Character.getNumericValue(col[0]) - 10;
        rtn = board[numRow][numCol].getPiece();
        board[numRow][numCol].setTile(null);;


        return rtn;
    }

    /**
     * Prints board with rows and column as given and all objects in it as they stand
     */
    public void printBoard() {
        char[] row = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] column = {'8', '7', '6', '5', '4', '3', '2', '1'};
        for(int i = 0; i<length; i++) {
            System.out.println();
            for(int j = 0; j<width; j++) {
                System.out.print(board[i][j].getSymbol());
                if(j == 7) {
                    System.out.print(" " + column[i]);
                }
            }
        }
        System.out.println();
        for(int i = 0; i<length; i++) {
            System.out.print(row[i]+ "  ");
        }
        System.out.println();
        if(inCheck) {
            System.out.println("You are in check");
        }
        System.out.println();
    }

}
