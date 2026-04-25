package CoreJava.LMS.Library;

import java.util.Scanner;

public class ReturnBook implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
       s=new Scanner(System.in);
       System.out.println("Enter the book name");
        String str= s.next();

        if (!database.getAllBorrowings().isEmpty()) {
            for(Borrowing b: database.getAllBorrowings())
                {

                    if (b.getBooks().getName().matches(str) && b.getUser().getName().matches(user.getName())) {
                        Books book=b.getBooks();
                        int i=database.getAllBooks().indexOf(book);
                        if (b.getdaysLeft()<0) {
                             System.out.println("You are late. You have to pay:"+Math.abs(b.getdaysLeft()*50)+"as fine");
                            
                        }
                        
                        book.setBrwcopies(book.getBrwcopies()+1);
                        database.returnBook(b,book,i);
                        System.out.println("Book returned...... Thank you!");
                        break;
                    }
                    else
                        System.out.println("You didnot borrowed this book");
                }

        }
        else
            System.out.println("You didnot borrow this book");
        user.menu(database, user);
    }
    
    
}
