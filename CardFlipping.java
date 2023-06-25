/*
 * Author: Hunter Pion
 * Date: 6/25/2023
 * 
 * Main class for CardFlipping project
 * 
 * Takes input in the form of an "input.txt" file containing rows of cards available in a standard deck of 52 and outputs n "output.txt" file with a single deck
 * consisting of those cards by flipping half of the cards onto the other half, starting with rows, then columns. The top rows are flipped onto the bottom rows.
 * The left columns are flipped onto the right columns. In the case of an odd number of rows or columns, the center row or column is ignored.
 * 
 * The input file should contain any number of rows of cards seperated by single spaces. There should be the same number of cards in each row.
 * 
 * Cards are formatted as a three character string as defined in the included readme file.
 */

 import java.io.*;
 import java.util.Scanner;

public class CardFlipping {
    public static void main(String[] args) throws IOException
    {
        // create scanner using input.txt
        Scanner input = new Scanner(new File("input.txt"));

        // Find number of rows and columns in input.txt
        int rows = 0;
        while(input.hasNextLine())
        {
            rows++;
            input.nextLine();
        }
        input.reset();
        int columns = 0;
        Scanner lineScnr = new Scanner(input.nextLine());
        while (lineScnr.hasNext())
        {
            columns++;
            lineScnr.next();
        }
        input.reset();

        // create array of CardLists from input
        CardList[][] cardArray = new CardList[rows][columns];

        for (int i = 0; i < rows; i++)
        {
            // read next line into lineScnr and use it to create row i
            lineScnr = new Scanner(input.nextLine());
            for (int j = 0; j < columns; j++)
            {
                cardArray[i][j] = new CardList();
                cardArray[i][j].addCard(lineScnr.next());
            }
        }
    }
}
