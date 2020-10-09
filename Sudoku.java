import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

class Sudoku 
{
    
    // Print contents of array list 
    // Each entry of the list is a string array so we have to go through that string array 
    public static void PrintBoard(String [][] Board)
    {
        for(int i = 0; i < 9;i++)
        {
            if(i%3 == 0) {System.out.println("\n[]=====[]=====[]=====[]");}
            else{System.out.println();}
            for(int k = 0; k < 9;k++)
            {
                if(k%3 == 0) {System.out.print("[]");}
                if(Board[i][k].equals("")) System.out.print(" "); // if the indexed value is empty from the csv 
                else System.out.print(Board[i][k]);
                if(k%3 != 2){System.out.print("|");}
            }
            System.out.print("[]");
        }
        System.out.print("\n[]=====[]=====[]=====[]\n");
    }

    public static void Solve(String [][]Board)
    {
        Hash Hash = new Hash();
    }


    public static void main(String[] args) throws FileNotFoundException 
    {
        // Load array list variable
        Scanner FileReader = new Scanner(new File(".\\res\\Matrix.csv"));
        String [][] Board = new String[9][9];
        
        // go through each line
        // ensuring size 9 array 
        // Each line is an array, add that to the array list 
        for(int i = 0; i < 9; i++) Board[i] = FileReader.nextLine().split(",",9); 
        FileReader.close();

        PrintBoard(Board);

        // Solve the board 
        Solve(Board);

    }
}