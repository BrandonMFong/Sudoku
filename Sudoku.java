import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

class Sudoku 
{
    public static void main(String[] args) 
    {
        try 
        {
            File MyFile = new File(".\\res\\Matrix.txt");
            Scanner FileReader = new Scanner(MyFile);
            while (FileReader.hasNextLine()) 
            {
                String data = FileReader.nextLine();
                System.out.println(data);
            }
            FileReader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}