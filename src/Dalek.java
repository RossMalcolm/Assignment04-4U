/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malcr1272
 */
public class Dalek {
    //make row integer for dalek
    private int row;
    //make coloumn integer for dalek
    private int col;
    //make boolean for crashing
    private boolean hasCrashed;

    /**
     * Create Class for the daleks
     * @param row returns the row of the dalek
     * @param col returns the coloumn of the dalek
     */
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * create class for the movement towards the doctor
     * @param doc gets the position of the doctor 
     */
    public void advanceTowards(Doctor doc) {
        //if the dalek has crashed do nothing
        if (hasCrashed) {
        } else {
            //if the dalek has not crashed find out if the doctors row & coloumn is more
            //or less than the daleks row & coloumn and move the daleks towards tthe doc
            if (doc.getrow() > row) {
                this.row += 1;
            }
            if (doc.getrow() < row) {
                this.row -= 1;
            }
            if (doc.getcol() > col) {
                this.col += 1;
            }
            if (doc.getcol() < col) {
                this.col -= 1;
            }
        }
    }
    /**
     * allow the daleks to crash
     * @param d the dalek that is being tested
     */
    public void crash(Dalek d) {
        if (row == d.row && col == d.col) {
            hasCrashed = true;
        }
    }
    /**
     * be able to check if the dalek has crashed
     * @return 
     */
    public boolean hasCrashed(){
        return this.hasCrashed;      
    }
    /**
     * be able to check the row of the dalek
     * @return the row the dalek is on
     */
    public int getrow() {
        return this.row;
    }
    /**
    * be able to check the coloumn of the dalek
    * @return the coloumn the dalek is on
    */
    public int getcol() {
        return this.col;
    }
}
