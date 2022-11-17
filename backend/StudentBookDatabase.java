package backend;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author eyada
 */
public class StudentBookDatabase extends Database{
    private String filename="StudentsBooks.txt";

    public StudentBookDatabase(String filename) {
        super(filename);
        this.filename = filename;
    }


    @Override
    public void readFromFile() {
        try {
            File file = new File("StudentsBooks.txt");
            try(Scanner sc = new Scanner(file))
            {
                String str;
                while (sc.hasNextLine())
                {
                    str = sc.nextLine();
                    Record rTemp = createRecordFrom(str);
                    records.add(rTemp);
                }

            }
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("ERROR IN OPENING FILE AND TRYING TO MODIFY IN IT");

        }
    }
    /*public void readFromFile()
    {
        records.clear();
        File f = new File("StudentsBooks.txt");
        try (Scanner sc = new Scanner(f))
        {
            String str;
            while (sc.hasNextLine())
            {
                StudentBook a;
                str=sc.nextLine();
                a = createRecordFrom(str);
                records.add(a);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    @Override
    public StudentBook createRecordFrom(String line)
    {
        StudentBook a;
        String[] tokens = line.split(",");
        a = new StudentBook(tokens[0],tokens[1],LocalDate.parse(tokens[2]));
        return a;
    }

}
    
   