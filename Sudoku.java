import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Sudoku 
{
    public static void main(String[] args) 
    {
        // Load array list variable
        try 
        {
            // File MyFile = new File(".\\res\\Matrix.csv");
            // return new Scanner(MyFile);
            Scanner FileReader = new Scanner(new File(".\\res\\Matrix.csv"));
            ArrayList<String> Rows = new ArrayList<String>();
            while (FileReader.hasNextLine()) 
            {
                // String data = FileReader.nextLine();
                // System.out.println(data);
                Rows.add(FileReader.nextLine());
            }
            FileReader.close();
            // Print contents of array list 
            for(int i = 0; i < Rows.size();i++)
            {
                System.out.println(Rows.get(i));
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}