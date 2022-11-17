package backend;

import java.io.*;
import java.util.ArrayList;

public abstract class Database {
    public ArrayList<Record>records;
    private String filename;

    public Database(String filename) {
        this.filename = filename;
        records = new ArrayList<Record>();
        this.readFromFile();
    }
    public abstract void readFromFile();

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords()
    {
        return records;
    }

    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (((this.records.get(i)).getSearchKey()).equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Record getRecord(String key) {
        for (int i = 0; i < records.size();i++) {
            if (((records.get(i).getSearchKey()).equals(key)))
                return records.get(i);
        }
        return null;
    }

    public void insertRecord(Record record) {
        if(this.contains(record.getSearchKey()))
        {
            //System.out.println("this id already exist try another id");
        }
        else
        {
            records.add(record);
            //System.out.println("another record was added");
        }


    }

    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                records.remove(i);
                return;
            }
        }
    }
    
    public void saveToFile()
    {
        try{
            try(FileWriter mywriter = new FileWriter(filename)){
                for(int i = 0; i < records.size(); i++) {
                    mywriter.write((records.get(i).lineRepresentation()));
                    mywriter.write("\n");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in opening file (Writing to file not accomplished)");
        }
    }
}
