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
        input = new Scanner(new File("input.txt"));
        int columns = 0;
        Scanner lineScnr = new Scanner(input.nextLine());
        while (lineScnr.hasNext())
        {
            columns++;
            lineScnr.next();
        }
        input = new Scanner(new File("input.txt"));

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

        // flip the top half of the cards onto the bottom half of the cards until only one row remains
        // if there are an odd number of rows, ignore the center row
        while (rows > 1)
        {
            int removedRows = rows / 2;
            for (int i = 0; i < (removedRows); i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    cardArray[i][j].flip(cardArray[rows - 1 - i][j]);
                }
            }
            rows -= removedRows;
            // create new cardArray
            CardList[][] oldArray = cardArray;
            cardArray = new CardList[rows][columns];
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    cardArray[i][j] = oldArray[i + removedRows][j];
                }
            }
        }

        // flip the left half of the cards onto the right half of the cards until only one column remains
        // if there are an odd number of columns, ignore the center column
        while (columns > 1)
        {
            int removedColumns = columns / 2;
            for (int i = 0; i < removedColumns; i++)
            {
                cardArray[0][i].flip(cardArray[0][columns - 1 - i]);
            }
            columns -= removedColumns;

            // create new cardArray
            CardList[][] oldArray = cardArray;
            cardArray = new CardList[1][columns];
            for (int j = 0; j < columns; j++)
            {
                cardArray[0][j] = oldArray[0][j + removedColumns];
            }
        }

        // create an output.txt file with the final deck
        String output = cardArray[0][0].toString();
        FileWriter outputWriter = new FileWriter("output.txt");
        outputWriter.write(output);
        outputWriter.close();
    }
}
