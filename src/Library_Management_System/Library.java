package Library_Management_System;
import java.util.HashMap;
import java.util.Scanner;
public class Library {
    Scanner sc = new Scanner(System.in);
    Book_Details  bd = new Book_Details ();
    HashMap<Integer,String> bookhashmp = new HashMap<>();
    HashMap<Integer,String> userhashmp = new HashMap<>();
    userDetails  obj = new userDetails ();
    public void addBook(){
        System.out.println("enter book details which you want add in the library");
        System.out.println("enter book title");
        String title = sc.nextLine();
        bd.setTitle(title);
        System.out.println("enter book unique id");
        int bid = sc.nextInt();
        bd.setId(bid);
        String nm =bd.getTitle();
        int idno = bd.getId();
        System.out.println("Book Title Name: " + nm);
        System.out.println("Book Unique Id: " + idno);
        bookhashmp.put(idno,nm);
        System.out.println(bookhashmp);
        System.out.println("Book added successfully!");
    }
    public void issueBook(){
        System.out.println("enter book ID to issue book");
        int bkid =sc.nextInt();
        System.out.println("book Id is:="+bkid);
        if(bookhashmp.containsKey(bkid)){
            System.out.println("book is available");
            System.out.println("book name of corresponding book id"+".."+bookhashmp.entrySet());
            System.out.println("enter user name ");
            String unm = sc.nextLine();
            obj.setName(unm);
            String usrnm = obj.getName();
            System.out.println("User Name: " + usrnm);
            userhashmp.put(bkid,unm);
            System.out.println(userhashmp);
            System.out.println("Book borrowed successfully!");
        }
        else{
            System.out.println("book is not available");
        }
    }
    public void returnBook(){
        System.out.println("enter book ID to return book");
        int bkrtn =sc.nextInt();
        System.out.println("book Id is:="+bkrtn);
        System.out.println("enter user name,who has come to return the book ");
        String unm = sc.nextLine();
        //obj.setName(unm);
        // String usrnm = obj.getName();
        System.out.println("User Name: " + unm);
        userhashmp.put(bkrtn,unm);
        System.out.println(userhashmp);
        System.out.println("Book returned successfully!");
    }
    public void displayBookInformation(){
        System.out.println("enter book ID to search");
        int bookid = sc.nextInt();
        System.out.println(bookid);
        if(bookhashmp.containsKey(bookid)){
            System.out.println("BOOK ID & BOOK TITLE :="+bookhashmp.entrySet());
        }

    }
    public static void main(String[] args) {
        Scanner sc2 = new Scanner(System.in);
        Library refob = new Library();
        System.out.println("welcome to the Library Management System!");
        System.out.println("1=addBook..2=returnBook...3=issueBook...4displayBookInformation...5=Exiting");
        System.out.println("enter any number,whatever you want");
        //  System.out.println("enter your choice");
        int ch = sc2.nextInt();
        //int chos=choice();
        switch(ch){
            case 1:
                refob.addBook();
                break;
            case 2:
                refob.returnBook();
                break;
            case 3:
                refob.issueBook();
                break;
            case 4:
                refob.displayBookInformation();
                break;
            default: System.out.println("Invalid choice");
        }
    }
}
class Book_Details {
    private String book_title;
    private int unique_book_id;
    private String book_author_name;
    public String getTitle() {
        return book_title;
    }
    public void setTitle(String book_name) {
        this.book_title = book_name;
    }
    public int getId(){
        return unique_book_id;
    }
    public void setId(int book_id) {
        this.unique_book_id = book_id;
    }
    public String getAuthorName() {
        return book_author_name;
    }
    public void setAuthorName(String author_name) {
        this.book_author_name = author_name;
    }
}
class userDetails {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}