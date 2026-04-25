package CoreJava.LMS.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateFine implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
      s=new Scanner(System.in);
      System.out.println("Enter the book's name");
      String str= s.next();

      ArrayList<Borrowing> borrowings= database.getAllBorrowings();

      for(Borrowing b:borrowings)
      {
        if (b.getBooks().getName().matches(str)&& b.getUser().getName().matches(user.getName())) {
            if (b.getdaysLeft()<0) {
                System.out.println("You are late. You have to pay:"+Math.abs(b.getdaysLeft()*50)+"as fine");
                
            }
            else
                System.out.println("No fine yet ");
        }
      }
      user.menu(database, user);
    }
    
}
