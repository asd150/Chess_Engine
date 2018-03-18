package chess;
/**
 * 2 player Chess
 * @author Arthkumar Desai
 * @author Roman Stashchyshyn*/


import java.util.ArrayList;


public class Knight extends Piece{

    public Knight(String team) {
        super("N");
        this.team = team;

    }


    public ArrayList<String> movePiece(Tile[][] board) {


        ArrayList<String> moves = new ArrayList<String>();

        if(team.equals("w")) {

            //u u r
            if(row != 7 && column > 1) {
                String position1;
                if(board[column-2][row+1].getPiece() == null || board[column-2][row+1].getPiece().getTeam() =="b"){
                    position1 = convertMove(column-2,row+1);
                    moves.add(position1);
                    // System.out.println(moves);
                }
            }

            //u r r
            if(row < 6 && column != 0) {
                String position2;
                if(board[column-1][row+2].getPiece() == null || board[column-1][row+2].getPiece().getTeam() =="b"){
                    position2 = convertMove(column-1,row+2);
                    moves.add(position2);
                    //System.out.println(moves);
                }
            }

            //d r r
            if(row < 6 && column != 7) {
                String position3;
                if(board[column+1][row+2].getPiece() == null || board[column+1][row+2].getPiece().getTeam() =="b"){
                    position3 = convertMove(column+1,row+2);
                    moves.add(position3);
                    //System.out.println(moves);
                }
            }

            //d d r
            if(row != 7 && column < 6) {
                String position4;
                if(board[column+2][row+1].getPiece() == null || board[column+2][row+1].getPiece().getTeam() =="b"){
                    position4 = convertMove(column+2,row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }

            // u u l
            if(row != 0 && column > 1) {
                String position5;
                if(board[column-2][row-1].getPiece() == null || board[column-2][row-1].getPiece().getTeam() =="b"){
                    position5 = convertMove(column-2,row-1);
                    moves.add(position5);
                }
            }

            //u l l
            if(row > 1 && column != 0) {
                String position6;
                if(board[column-1][row-2].getPiece() == null || board[column-1][row-2].getPiece().getTeam() =="b"){
                    position6 = convertMove(column-1,row-2);
                    moves.add(position6);
                    //System.out.println(moves);
                }
            }

            //d l l
            if(column != 7 && row > 1) {
                String position7;
                if(board[column+1][row-2].getPiece() == null || board[column+1][row-2].getPiece().getTeam() =="b"){
                    position7 = convertMove(column+1,row-2);
                    moves.add(position7);
                    //System.out.println(moves);
                }
            }

            //d d l
            if(column < 6 && row != 0) {
                String position8;
                if(board[column+2][row-1].getPiece() == null || board[column+2][row-1].getPiece().getTeam() =="b"){
                    position8 = convertMove(column+2,row-1);
                    moves.add(position8);
                    //System.out.println(moves);
                }
            }

        }else {
            //u u r
            if(row != 7 && column > 1) {
                if(board[column-2][row+1].getPiece() == null || board[column-2][row+1].getPiece().getTeam() =="w"){
                    String position1;
                    position1 = convertMove(column-2,row+1);
                    moves.add(position1);
                    //System.out.println(moves);
                }
            }
            //u r r
            if(row < 6 && column != 0) {
                String position2;
                if(board[column-1][row+2].getPiece() == null || board[column-1][row+2].getPiece().getTeam() =="w"){
                    position2 = convertMove(column-1,row+2);
                    moves.add(position2);
                    //System.out.println(moves);
                }
            }
            // d r r
            if(row < 6 && column != 7) {
                String position3;
                if(board[column+1][row+2].getPiece() == null || board[column+1][row+2].getPiece().getTeam() =="w"){
                    position3 = convertMove(column+1,row+2);
                    moves.add(position3);
                    //System.out.println(moves);
                }
            }
            //d d r
            if(row != 7 && column < 6) {
                String position4;
                if(board[column+2][row+1].getPiece() == null || board[column+2][row+1].getPiece().getTeam() =="w"){
                    position4 = convertMove(column+2,row+1);
                    moves.add(position4);
                    //System.out.println(moves);
                }
            }
            //u u l
            if(row != 0 && column > 1) {
                String position5;
                if(board[column-2][row-1].getPiece() == null || board[column-2][row-1].getPiece().getTeam() =="w"){
                    position5 = convertMove(column-2,row-1);
                    moves.add(position5);
                    //System.out.println(moves);
                }
            }
            // u l l
            if(row > 1 && column != 0) {
                String position6;
                if(board[column-1][row-2].getPiece() == null || board[column-1][row-2].getPiece().getTeam() =="w"){
                    position6 = convertMove(column-1,row-2);
                    moves.add(position6);
                    //System.out.println(moves);
                }
            }
            //d d l
            if(column != 7 && row > 1) {
                String position7;
                if(board[column+1][row-2].getPiece() == null || board[column+1][row-2].getPiece().getTeam() =="w"){
                    position7 = convertMove(column+1,row-2);
                    moves.add(position7);
                    //System.out.println(moves);
                }
            }
            //d l l
            if(column < 6 && row != 0) {
                String position8;
                if(board[column+2][row-1].getPiece() == null || board[column+2][row-1].getPiece().getTeam() =="w"){
                    position8 = convertMove(column+2,row-1);
                    moves.add(position8);
                    //System.out.println(moves);
                }
            }
        }

        //System.out.println(moves);
        return moves;

    }



}
