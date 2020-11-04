import java.io.File; 
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;
// https://www.geeksforgeeks.org/sudoku-backtracking-7/
class Sudoku 
{
    static int Max = 9;
    static String EmptySquare = "";

    public static boolean isSafe(String [][]Board, Hash Hash, int num)
    {
        int column = Hash.GetColumn();
        int row = Hash.GetRow();
        String numstring = String.valueOf(num);

        // Check if row is good
        for(int r = 0; r <= Max; r++)
        {
            if(Board[r][column].equals(numstring))
            {
                return false; 
            }
        }

        // Check if column is good
        for(int c = 0; c <= Max; c++)
        {
            if(Board[row][c].equals(numstring))
            {
                return false;
            }
        }

        // Check if block is good 

        return true;
    }
    
    // Print contents of array list 
    // Each entry of the list is a string array so we have to go through that string array 
    public static void PrintBoard(String [][] Board)
    {
        for(int i = 0; i < Max;i++)
        {
            if(i%3 == 0) {System.out.println("\n[]=====[]=====[]=====[]");}
            else{System.out.println();}
            for(int k = 0; k < Max;k++)
            {
                if(k%3 == 0) {System.out.print("[]");}
                if(Board[i][k].equals(EmptySquare)) System.out.print(" "); // if the indexed value is empty from the csv 
                else System.out.print(Board[i][k]);
                if(k%3 != 2){System.out.print("|");}
            }
            System.out.print("[]");
        }
        System.out.print("\n[]=====[]=====[]=====[]\n");
    }

    public static boolean Solve(String [][]Board)
    {
        boolean Done = false;
        Hash Hash = new Hash(); // Remember that Hash is not zero index 
        // Hash.SetRow(5); Hash.SetColumn(8); // test values

        // Find an empty square
        for(int r = 0; r < Max; r++)
        {
            for(int c = 0; c < Max; c++)
            {
                if(Board[r][c].equals(EmptySquare))
                {
                    // Record row/col/block
                    Hash.SetRow(r+1); Hash.SetColumn(c+1); 
                    System.out.println(MessageFormat.format("\nWe are in block {0}", Hash.GetBlockNum()));

                    // Go through and fill in empty squares
                    for(int num = 1; num <= Max; num++)
                    {
                        if(isSafe(Board,Hash,num))
                        {
                            Board[r][c] = String.valueOf(num); // convert to string
                            break;
                            // TODO what to do after? 
                        }
                    }
                }
            }
        }

        return Done;
    }


    public static void main(String[] args) throws FileNotFoundException 
    {
        // Load array list variable
        Scanner FileReader = new Scanner(new File(".\\res\\Matrix.csv"));
        String [][] Board = new String[Max][Max];
        
        // go through each line
        // ensuring size 9 array 
        // Each line is an array, add that to the array list 
        for(int i = 0; i < Max; i++) Board[i] = FileReader.nextLine().split(",",Max); 
        FileReader.close();

        PrintBoard(Board);

        // Solve the board 
        if(Solve(Board)) PrintBoard(Board);

    }
}