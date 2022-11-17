package backend;

public class Book implements Record{
    private String bookName;
    private int bookQuantity;
    private String bookPublisher;
    private String bookAuthorName;
    private String bookid;

    public Book(String id, String title, String authorName, String publisherName, int quantity){
        this.bookid = id;
        this.bookName = title;
        this.bookAuthorName = authorName;
        this.bookPublisher = publisherName;
        this.bookQuantity = quantity;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String lineRepresentation()
    {
        return bookid+","+bookName+","+bookAuthorName+","+bookPublisher+","+bookQuantity;
    }

    @Override
    public String getSearchKey()
    {
        return bookid;
    }

}

//old
/*public class Book implements Record{
    private String bookName;
    private int bookQuantity;
    private String bookPublisher;
    private String bookAuthorName;
    private String bookid;

    public Book(String id, String title, String authorName, String publisherName, int quantity){
        this.bookid = id;
        this.bookName = title;
        this.bookAuthorName = authorName;
        this.bookPublisher = publisherName;
        this.bookQuantity = quantity;
    }

    @Override
    public String lineRepresentation()
    {
        return bookid+", "+bookName+", "+bookAuthorName+", "+bookPublisher+", "+bookQuantity;
    }

    @Override
    public String getSearchKey()
    {
        return bookid;
    }

    public void decrementQuantity(){

        this.bookQuantity--;

    }

    public void incrementQuantity(){

        this.bookQuantity++;

    }
}
*/