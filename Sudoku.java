import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

class Sudoku 
{
    static int Max = 9;
    static String EmptySquare = "";
    
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

        // Remember that Hash is not zero index 
        Hash Hash = new Hash();
        Hash.Column = 1; // Column 1
        Hash.Row = 1; // Row 1
        Hash.Block.Num = 1; //Block 1

        // Find an empty square
        for(int r = 0; r < Max; r++)
        {
            for(int c = 0; c < Max; c++)
            {
                if(Board[r][c].equals(EmptySquare))
                {
                    Hash.Row = r; Hash.Column = c;
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