package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */

public class Board {

    public static final int rowL = 8;
    public static final int columnW = 8;
    public static Tile[][] boardSetup = new Tile[rowL][columnW];
    private int isWhite =1;
    Piece fromCheck;
    public Board() {


       for(int i =0; i < rowL;i++){
           for(int j=0; j< columnW;j++) {
               Tile tile = new Tile();
               if (i == 0) {
                   if (j == 0 || j == 7) {
                       Piece rook = new Rook("b");
                       tile.setPiece(rook);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] = tile;
                   } else if (j == 1 || j == 6) {
                       Piece knight = new Knight("b");
                       tile.setPiece(knight);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] = tile;
                   } else if (j == 2 || j == 5) {
                       Piece bishop = new Bishop("b");
                       tile.setPiece(bishop);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] = tile;
                   } else if (j == 3) {
                       Piece queen = new Queen("b");
                       tile.setPiece(queen);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] = tile;

                   } else if (j == 4) {
                       Piece king = new King("b");
                       tile.setPiece(king);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] = tile;
                   }

               } else if (i == 1) {
                   Piece pawn = new Pawn("b");
                   tile.setPiece(pawn);
                   tile.nextMoves(j,i);
                   boardSetup[i][j] = tile;
               }
               else if(i ==2 || i == 4){
                   if(isWhite==1){
                       tile.setColor("w");

                       boardSetup[i][j] = tile;

                       isWhite=0;
                   }
                   else{
                       tile.setColor("b");
                       boardSetup[i][j] = tile;
                       isWhite=1;
                   }


               }
               else if(i == 3 || i == 5){
                   if(isWhite==1){
                       tile.setColor("b");

                       boardSetup[i][j] = tile;

                       isWhite=0;
                   }
                   else{
                       tile.setColor("w");
                       boardSetup[i][j] = tile;
                       isWhite=1;
                   }

               }
               else if( i == 6){
                   Piece pawn = new Pawn("w");

                   tile.setPiece(pawn);
                   tile.nextMoves(i,j);
                   boardSetup[i][j] =tile;
               }
               else if(i == 7){
                   if( j ==0 || j == 7){
                       Piece rook = new Rook("w");
                       tile.setPiece(rook);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] =tile;
                   }
                   else if(j == 1 || j == 6){
                       Piece knight = new Knight("w");
                       tile.setPiece(knight);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] =tile;
                   }
                   else if(j ==2 || j ==5){
                       Piece bishop = new Bishop("w");
                       tile.setPiece(bishop);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] =tile;
                   }
                   else if(j == 3){
                       Piece queen = new Queen("w");
                       tile.setPiece(queen);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] =tile;
                   }
                   else {
                       Piece king = new King("w");
                       tile.setPiece(king);
                       tile.nextMoves(i,j);
                       boardSetup[i][j] =tile;
                   }
               }
           }
       }
    }

    public ArrayList<String> makeMove(String from,String to){

        ArrayList<String> possibleMoves = null;
        Piece fromPiece = getPiece(from);
        Piece  toPiece  = getPiece(to);


        possibleMoves = fromPiece.moves(boardSetup);
        System.out.println(possibleMoves);
        System.out.println(fromPiece);
        return null;
    }
    public Piece getPiece(String from){
        char[] col = from.substring(0,1).toCharArray();
        String row = from.substring(1);
        int iCol = Character.getNumericValue(col[0])-10;
        int iRow = Math.abs((Integer.parseInt(row))-8);

        return boardSetup[iRow][iCol].getPiece();

    }



    public void printBoard(){
    String[] columns = {"8","7","6","5","4","3","2","1"};
      for(int i = 0; i <rowL;i++){
          System.out.println();
          for (int j = 0; j <columnW;j++){
              System.out.print(boardSetup[i][j].fillContents());


          }
          System.out.print(columns[i]);
      }
      String[] rows ={"a","b","c","d","e","f","g","h"};

      System.out.println();
      for(int i = 0; i < columnW;i++){
          System.out.print(rows[i] + "  ");
      }



}



}
