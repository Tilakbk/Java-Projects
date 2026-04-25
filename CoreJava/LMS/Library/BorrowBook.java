package CoreJava.LMS.Library;

import java.util.Scanner;

public class BorrowBook implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
       s=new Scanner(System.in);
       System.out.println("Enter the name of the book you want to borrow");
       String str= s.next();

       int i=database.getBooksName(str);

       if (i>-1) {
        Books book= database.getBook(i);
        if (book.getBrwcopies()>1) {
            Borrowing borrowing=new Borrowing(book, user);
            book.setBrwcopies(book.getBrwcopies()-1);
            database.borrowBook(borrowing,book,i);
            System.out.println("You must return the book before 14 days from now\n"+"Expiry date:"+borrowing.getFinish()+"\nENJOY");
            
        }
        else
            System.out.println("This book is not available for borrowing");
       }
       else
       {
        System.out.println("Book doesnot exists");
       }
       user.menu(database, user);
    }
    
    
}
