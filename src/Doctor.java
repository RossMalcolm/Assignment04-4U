/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malcr1272
 */
public class Doctor {
    //make row integer for doctor
    private int row;
    //make coloumn integer for doctor
    private int col;
    //make boolean for crashing 
    private boolean hasCrashed;
    
    /**
     * Make class for the doctor 
     * @param row return the row of the doctor
     * @param col return the col of the doctor
     */
    public Doctor(int row, int col){
     this.row = row;
     this.col = col;
    }
    /**
     * make class for moving doctor
     * @param newRow return the row the doctor moves to
     * @param newCol return the col the doctor moves to
     */
    public void move(int newRow, int newCol){
        //if the user clicks on a tile 1 spot next the the doctor
        if((newRow == row || newRow == row + 1 || newRow == row - 1 )&& 
           (newCol == col || newCol == col + 1 || newCol == col - 1)){
        //the click is the new row and coloumn
        this.row = newRow;
        this.col = newCol;            
        }else{            
        //otherwise just randomly teleport the doctor
        this.row = (int) (Math.random() * 12);
        this.col = (int) (Math.random() * 12);
        }               
    }
    /**
     * class for getting the row
     * @return the row of the doc
     */
    public int getrow(){
        return this.row;
    }
    /**
     * class for getting col
     * @return the col of the doctor
     */
    public int getcol(){
        return this.col;
    }
    /**
     * return if the doc has crashed
     */
     public void crashed() {
      this.hasCrashed = true;
        }
    
    
    public boolean hasCrashed(){
        return this.hasCrashed;      
    }
            
}
