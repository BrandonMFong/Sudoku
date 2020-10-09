import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Sudoku 
{
    
    // Print contents of array list 
    // Each entry of the list is a string array so we have to go through that string array 
    public static void PrintBoard(ArrayList<String[]> Rows)
    {
        for(int i = 0; i < Rows.size();i++)
        {
            if(i%3 == 0) {System.out.println("\n[]=====[]=====[]=====[]");}
            else{System.out.println();}
            for(int k = 0; k < Rows.get(i).length;k++)
            {
                if(k%3 == 0) {System.out.print("[]");}
                System.out.print(Rows.get(i)[k]);
                if(k%3 != 2){System.out.print("|");}
            }
            System.out.print("[]");
        }
        System.out.print("\n[]=====[]=====[]=====[]\n");
    }
    public static void main(String[] args) throws FileNotFoundException 
    {
        // Load array list variable
        Scanner FileReader = new Scanner(new File(".\\res\\Matrix.csv"));
        ArrayList<String[]> Rows = new ArrayList<String[]>();
        
        // go through each line
        while (FileReader.hasNextLine()) Rows.add(FileReader.nextLine().split(",")); // Each line is an array, add that to the array list 
        FileReader.close();

        PrintBoard(Rows);

    }
}