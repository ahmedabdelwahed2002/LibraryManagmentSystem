package backend;

public class LibrarianUser implements Record  {
    private String librarianId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address,String phoneNumber)
    {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String lineRepresentation()
    {
        String S = (librarianId+","+name+","+email+","+address+","+phoneNumber);
        return S;
    }
    @Override
    public String getSearchKey()
    {
        return librarianId;
    }
}
