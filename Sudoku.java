import java.io.File; 
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;
// https://www.geeksforgeeks.org/sudoku-backtracking-7/
class Sudoku 
{
    static int Max = 9;
    static String EmptySquare = "";
    Hash Hash = new Hash(); // Remember that Hash is not zero index 

    public static boolean isSafe(String [][]Board, Hash Hash)
    {
        // Check if row is good
        for(int row = 0; row <= Max; row++)
        {
            
        }

        // Check if column is good

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

        System.out.println(MessageFormat.format("\nWe are in block {0}", Hash.GetBlockNum()));

        // Find an empty square
        for(int r = 0; r < Max; r++)
        {
            for(int c = 0; c < Max; c++)
            {
                if(Board[r][c].equals(EmptySquare))
                {
                    // Record row/col/block
                    Hash.SetRow(r+1); Hash.SetColumn(c+1); // remember we are not zero indexing 

                    // Go through and fill in empty squares
                    for(int num = 1; num <= Max; num++)
                    {
                        if(isSafe())
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