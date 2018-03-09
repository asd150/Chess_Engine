package board;

import java.util.ArrayList;

/**
 * @author Arthkumar Desai
 * */

public class Pawn extends Piece {
    public Pawn(String team) {
        super("P");
        this.team = team;
    }


    @Override
    public ArrayList<String> moves(Tile[][] tile) {
        String pos1, pos2, pos3, pos4;
        ArrayList<String> movestoadd = new ArrayList<>();
        if (notMoved()) {
            hasMoved = false;
        }

        if (team == "w") {
            //White Team

            pos1 = convertMove(row - 1, column);
            pos2 = convertMove(row - 2, column);

            //System.out.println(pos2);
            //if the pawn is nnot moves from the initial place


            if (!hasMoved) {
                if (tile[row - 1][column].getPiece() == null && tile[row - 2][column].getPiece() == null) {
                    movestoadd.add(pos2);
                    movestoadd.add(pos1);
                } else if (tile[row - 1][column].getPiece() == null) {
                    movestoadd.add(pos1);
                }
                hasMoved = true;
            } else if (tile[row - 1][column].getPiece() == null) {
                movestoadd.add(pos1);
            }
            if (column == 0) {
                if (tile[row - 1][column + 1].getPiece() == null && tile[row - 1][column].getPiece().getTeam() == "b") {
                    pos3 = convertMove(row - 1, column + 1);
                    movestoadd.add(pos3);
                }

            } else if (column == 7) {
                if (tile[row - 1][column - 1].getPiece() == null && tile[row - 1][column - 1].getPiece().getTeam() == "b") {
                    pos4 = convertMove(row - 1, column - 1);
                    movestoadd.add(pos4);
                }

                else {
                    if(tile[row-1][column-1].getPiece()==null && tile[row-1][column-1].getPiece().getTeam()=="b"){
                        pos4 = convertMove(row-1,column-1);
                        movestoadd.add(pos4);

                    }
                    if(tile[row-1][column+1].getPiece()==null && tile[row-1][column+1].getPiece().getTeam()=="b"){
                        pos3=convertMove(row-1,column+1);
                    movestoadd.add(pos3);

                    }
                }


            }
        else {
           //Black Team
            pos1 = convertMove(row+1,column);
            pos2 = convertMove(row+2,column);

            if(!hasMoved){
                if(tile[row+1][column].getPiece()==null && tile[row+2][column].getPiece()==null){
                    movestoadd.add(pos2);
                    movestoadd.add(pos1);

                }
                else if(tile[row+1][column].getPiece()==null){
                    movestoadd.add(pos1);
                }
                hasMoved=true;
            }
            else if (tile[row+1][column].getPiece()==null){
                    movestoadd.add(pos1);
            }
             if(column==0){
                if(tile[row+1][column+1].getPiece()==null && tile[row+1][column].getPiece().getTeam()=="w"){
                    pos3 = convertMove(row+1,column+1);
                    movestoadd.add(pos3);
                }

            }
            else if(column==7){
                if(tile[row+1][column-1].getPiece() ==null && tile[row+1][column-1].getPiece().getTeam()=="w"){
                    pos4 = convertMove(row+1,column-1);
                    movestoadd.add(pos4);
                }
             }else {
                if(tile[row+1][column-1].getPiece()==null && tile[row+1][column-1].getPiece().getTeam()=="w"){
                    pos3 = convertMove(row+1,column-1);
                    movestoadd.add(pos3);
                }
                 if (tile[row + 1][column + 1].getPiece() == null && tile[row + 1][column + 1].getPiece().getTeam() == "w") {

                    pos4 = convertMove(row+1,column+1);
                    movestoadd.add(pos4);
                 }
             }


        }
        }
            return movestoadd;

        }

    }

