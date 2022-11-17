package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDatabase extends Database{

    //private ArrayList<Record> records;
    private String filename="Books.txt";

    public BookDatabase(String filename) {
        super(filename);
        this.filename = filename;
    }

    public void readFromFile() {
        try {
            File file = new File("Books.txt");
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
        File f = new File("Books.txt");
        try (Scanner sc = new Scanner(f))
        {
            String str;
            while (sc.hasNextLine())
            {
                Book a;
                str=sc.nextLine();
                a = createRecordFrom(str);
                records.add(a);
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    @Override
    public Book createRecordFrom(String line)
    {
        String[] tokens = line.split(",");
        return new Book(tokens[0], tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
    }

}
