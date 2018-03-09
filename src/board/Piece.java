package board;

/**
 * @author Arthkumar Desai
 * */




public abstract class Piece implements Movement{

    public int row;
    public int column;
    //which team
    public String team;
    //which tyoe of piece
    public String type;


    public Boolean hasMoved = true;

   //Define the type of piece
    public Piece(String type){
        this.type=type;
    }

    public String getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }
   // public abstract ArrayList<String> movepiece(Tile[][] onBoard );

    public boolean notMoved(){
        return this.hasMoved;

    }
    public void setMove(boolean bool){
        this.hasMoved=bool;

    }

    public String convertMove(int rowM, int columnM) {

        String rtn = null;
        StringBuilder sb = new StringBuilder();
        //System.out.println(columnM + " " + rowM);
        int rRow = 8 - rowM;
        char cRow, cCol;
        cRow = (char)rRow;
        if(columnM == 0) {
            cCol = 'a';
        }else if(columnM == 1) {
            cCol = 'b';
        }else if(columnM == 2) {
            cCol = 'c';
        }else if(columnM == 3) {
            cCol = 'd';
        }else if(columnM == 4) {
            cCol = 'e';
        }else if(columnM == 5) {
            cCol = 'f';
        }else if(columnM == 6) {
            cCol = 'g';
        }else{
            cCol = 'h';
        }

        sb.append(cCol);
        sb.append(rRow);
        rtn = sb.toString();


        return rtn;
    }
}
