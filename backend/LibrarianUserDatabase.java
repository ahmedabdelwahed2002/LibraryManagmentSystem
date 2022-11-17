package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianUserDatabase extends Database {
    private String filename = "Librarians.txt";

    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

    public void readFromFile() {
        try {
            File file = new File("Librarians.txt");
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
   /* public void readFromFile() {
        records.clear();
        File f = new File(filename);
        try (Scanner sc = new Scanner(f)) {
            String str;
            while (sc.hasNextLine()) {
                LibrarianUser a;
                str = sc.nextLine();
                //System.out.println("str in func read file LUDB"+str);
                a = createRecordFrom(str);
                // String[] tokens = str.split(",");
                // a = new LibrarianUser(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                records.add(a);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Reading from file not accomplished(file may be empty)");
            e.printStackTrace();
        }
    }
    */


    public LibrarianUser createRecordFrom(String line) {
        LibrarianUser a;
        String[] tokens = line.split(",");
        a = new LibrarianUser(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
        return a;
    }

}
