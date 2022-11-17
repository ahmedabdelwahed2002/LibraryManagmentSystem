package backend;

import constants.FileNames;
import java.util.ArrayList;

public class AdminRole {
    private LibrarianUserDatabase database = new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);

    public AdminRole() {

    }
    public void setDatabase(LibrarianUserDatabase database) {
        this.database = database;
    }
    
    public LibrarianUserDatabase getDatabase(){
        return this.database;
    }
    
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber)
    {
        if (!database.contains(librarianId)) {
            LibrarianUser L1= new LibrarianUser(librarianId, name, email, address, phoneNumber);
            database.insertRecord(L1);
            //database.saveToFile();
        }
    }
    public ArrayList<Record> getListOfLibrarians()
    {
        return database.returnAllRecords();
    }
    public void removeLibrarian (String key)
    {
        database.deleteRecord(key);
        //database.saveToFile();
    }
    ////
    public void logout()
    {
        database.saveToFile();
    }
}
