package backend;

import java.time.LocalDate;

public class StudentBook implements Record{

    private String studentid;
    private String bookid;
    private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate){
        this.studentid=studentId;
        this.bookid=bookId;
        this.borrowDate=borrowDate;
    }

    public String getStudentId(){
        return this.studentid;
    }

    public String getBookId(){
        return this.bookid ;
    }

    public LocalDate getBorrowDate(){
        return this.borrowDate;
    }

    @Override
    public String lineRepresentation()
    {
        return studentid+","+bookid+","+borrowDate;
    }

    @Override
    public String getSearchKey()
    {
        return studentid+","+bookid;
    }

}
