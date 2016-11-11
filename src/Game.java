
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author malcr1272
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the game board
        Board board = new Board(12, 12);
        //make array to store daleks
        Dalek[] daleks = new Dalek[3];
        //make 3 daleks spawn randomly
        for (int i = 0; i < 3; i++) {
            daleks[i] = new Dalek((int) (Math.random() * 12), (int) ((Math.random() * 12)));
            board.putPeg(Color.BLACK, daleks[i].getrow(), daleks[i].getcol());
        }

        //create doctor at random spot
        Doctor doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.GREEN, doc.getrow(), doc.getcol());

        while (doc.hasCrashed() != true) {
            
            //find where user is clicking
            Coordinate click = board.getClick();
            //remove doctor
            board.removePeg(doc.getrow(), doc.getcol());
            //change position of doctor
            doc.move(click.getRow(), click.getCol());
            //put peg in new position
            board.putPeg(Color.GREEN, doc.getrow(), doc.getcol());

            for (int i = 0; i < 3; i++) {
                //remove dalek peg
                board.removePeg(daleks[i].getrow(), daleks[i].getcol());
                //move daleks position one towards doctor
                daleks[i].advanceTowards(doc);
                //place peg in new dalek position
                board.putPeg(Color.BLACK, daleks[i].getrow(), daleks[i].getcol());
            }
            //for loop to go through each dalek
            for (int i = 0; i < 3; i++) {
                //for loop to compare each dalek to each other
                for (int j = 0; j < 3; j++) {
                    //when the daleks are not being compared to the same dalek
                    if (i != j) {
                        //test the dalek for a crash with the other dalek
                        daleks[i].crash(daleks[j]);
                        //if the dalek did crash
                        if (daleks[i].hasCrashed() == true) {
                           //place a red peg
                            board.putPeg(Color.RED, daleks[i].getrow(), daleks[i].getcol());
                        }
                    }
                }
            }
            //for loop to go through each dalek
            for(int i = 0; i <= 2; i++){
                //if the dalek is on the same position as the doctor
                if(daleks[i].getrow() == doc.getrow() &&
                   daleks[i].getcol() == doc.getcol()){
                    //the doctor has crashed
                    doc.crashed();
                    //remove doctor peg
                    board.removePeg(doc.getrow(),doc.getcol());
                    //remove dalek peg
                    board.removePeg(daleks[i].getrow(), daleks[i].getcol());
                    //put crashed doctor peg
                    board.putPeg(Color.yellow, doc.getrow(), doc.getcol());
                    //tell the user they lost
                    board.displayMessage("You lose !");
                }
            }
            //if all of the daleks have crashed and the doctor has not
            if (daleks[0].hasCrashed() == true && 
                daleks[1].hasCrashed() == true && 
                daleks[2].hasCrashed() == true &&
                doc.hasCrashed() == false){
                //tell user they one and end the game
                board.displayMessage("You Win !");
                break;               
            }
        }
    }
}
