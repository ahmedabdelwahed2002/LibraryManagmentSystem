package backend;

import constants.FileNames;
import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarianRole {

    private BookDatabase booksDatabase = new BookDatabase(FileNames.BOOKS_FILENAME);
    private StudentBookDatabase sBDatabase = new StudentBookDatabase(FileNames.STUDENTSBOOKS_FILENAME);
    public LibrarianRole(){

    }
    
    public BookDatabase getBookDatabase(){
        return this.booksDatabase;
    }
    public StudentBookDatabase getStudentBookDatabase(){
        return this.sBDatabase;
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity){

            Book b = new Book(id, title, authorName, publisherName, quantity);
            booksDatabase.insertRecord(b);
           // booksDatabase.saveToFile();
    }

    /*public void addBook(String id, String title, String authorName, String publisherName, int quantity){
        Book b=new Book(id,title,authorName,publisherName,quantity);
        if(booksDatabase.contains(id))
        {
            Book b1 = (Book) booksDatabase.getRecord(id);
            b1.incrementQuantity();
        }
        else
            booksDatabase.insertRecord(b);
        booksDatabase.saveToFile();
    }*/
    //public void addBook(String id, String title, String authorName, String publisherName, int quantity){
    //    Book b=new Book(id,title,authorName,publisherName,quantity);
    //    booksDatabase.insertRecord(b);
    //    booksDatabase.saveToFile();
    //    Book b1 = (Book) booksDatabase.getRecord(id);

    //    /*booksDatabase.getRecord(id)*/b1.incrementQuantity();

    //    booksDatabase.saveToFile();
    //}


    public ArrayList<Record> getListOfBooks(){
        return booksDatabase.returnAllRecords();
    }

    //e7na ghayarna el type of arraylist l Record badal studentBook
    public ArrayList<Record> getListOfBorrowingOperations(){
        return sBDatabase.returnAllRecords();
    }


    public int borrowBook(String studentId, String bookId, LocalDate borrowDate){
        Book tempB1 = (Book) booksDatabase.getRecord(bookId);
        if(booksDatabase.contains(bookId)==false||tempB1.getBookQuantity()==0)
            return 0;
        else if(sBDatabase.contains(studentId+","+bookId)==true)
            return 1;
        else{

            tempB1.setBookQuantity(tempB1.getBookQuantity()-1);
            sBDatabase.insertRecord(sBDatabase.createRecordFrom(studentId+","+bookId+","+borrowDate));
            //booksDatabase.saveToFile();
            //sBDatabase.saveToFile();
            return 2;
        }
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate){
        double fee=0;
        Book tempB1 = (Book) booksDatabase.getRecord(bookId);
        tempB1.setBookQuantity(tempB1.getBookQuantity()+1);
        booksDatabase.insertRecord(booksDatabase.getRecord(bookId));
        //booksDatabase.saveToFile();
        StudentBook SBTemp1;
        SBTemp1 = (StudentBook) sBDatabase.getRecord(studentId+","+bookId);
        //System.out.println("pre debug");
        if (SBTemp1!=null){
            //System.out.println("debuging 1");
            if (returnDate.getDayOfYear()-SBTemp1.getBorrowDate().getDayOfYear() > 7){    
                //System.out.println("debug");
                sBDatabase.deleteRecord(studentId+","+bookId);
                //sBDatabase.saveToFile();
                return (returnDate.getDayOfYear() -SBTemp1.getBorrowDate().getDayOfYear() - 7) * 0.5;    
            }
            else{
                sBDatabase.deleteRecord(studentId+","+bookId);
                //sBDatabase.saveToFile();
                //System.out.println("detbugging 2");
                return 0;}
        }
        else 
            return 0;
    }






    /*public int borrowBook(String studentId, String bookId, LocalDate borrowDate){
        if(booksDatabase.contains(bookId)==false)
            return 0;
        else if(sBDatabase.contains(studentId+","+bookId)==true)
            return 1;
        else{
            booksDatabase.getRecord(bookId).decrementQuantity();
            sBDatabase.insertRecord(sBDatabase.createRecordFrom(studentId+","+bookId+","+borrowDate));
            booksDatabase.saveToFile();
            sBDatabase.saveToFile();
            return 2;
        }
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate){
        Book b1 = (Book) booksDatabase.getRecord(bookId);
        b1.incrementQuantity();
        sBDatabase.deleteRecord(studentId+","+bookId);
        booksDatabase.insertRecord(booksDatabase.getRecord(bookId));
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
        if(returnDate.getDayOfYear()-sBDatabase.getRecord(studentId+","+bookId).getBorrowDate().getDayOfYear()>7)
            return (returnDate.getDayOfYear()-sBDatabase.getRecord(studentId+","+bookId).getBorrowDate().getDayOfYear()-7)*0.5;
        else
            return 0;
    }
*/

    public void logout(){
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }

}
