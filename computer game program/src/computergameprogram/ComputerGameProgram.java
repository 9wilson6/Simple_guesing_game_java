/*
user keys in the number of rounds he wishes to play.
for each round the user enters his lucky number.
the program devides the number by a secret number (a random number for our case).
if remainder is zero after the division the game draws earning the player onli one point.
if the remainder is even the player earns 3 points.
if the the remainder is odd, the player loses three points.

 */
package computergameprogram;

import java.awt.HeadlessException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @Group *
 */
public class ComputerGameProgram {

    //Variables defination
    static int numberByUser;
    static int total, numOfTimes;
    static StringBuilder st = new StringBuilder();
    static int x = 0;
    static Random rad = new Random();
    static int y = rad.nextInt(4) + 1;

    public static void main(String[] args) {

        ComputerGameProgram.PlayGame();

    }

    public static void PlayGame() {

        //Scanner object to take in user input
        Scanner input = new Scanner(System.in);

        //Ask the player to key in a number for the number of rounds they wish to keep playing.
        //ensure the input is number format
        
        try {
            numOfTimes = Integer.parseInt(JOptionPane.showInputDialog(null, "How Many Times Do You want To Try Your Luck: "));
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Input", "Bad Number Format", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        // for loop to keep game playing untill the number of requested play times is over
        for (int i = 1; i < numOfTimes + 1; i++) {
       //ensure the input is number format
            try {
                numberByUser = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number " + i));
                //get the remainder after didviding by a secret number
                double result = numberByUser % y;
                if (result == 0) {
                    total += 1;
                    x = 1;

                } else if (result % 2 == 0) {
                    total += 3;

                    x = 3;

                } else if (result % 2 != 0) {
                    total -= 3;
                    x = -3;

                }
                //Append the the score of each round to a String 
                st.append("\n").append(x);
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Bad Number Format", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        }
        //make a decision on whether the player wins or loses
        if (total > 0) {
            JOptionPane.showMessageDialog(null, "You Worn !!! Your Score Log is\n" + st + "\n Toltal: " + total, " Worn", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "You Lost Your Score Log is\n" + st + "\n Toltal: " + total, " Sorry", JOptionPane.INFORMATION_MESSAGE);

        }

    }
}
