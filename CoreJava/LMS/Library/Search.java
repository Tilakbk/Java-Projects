package CoreJava.LMS.Library;

import java.util.Scanner;

public class Search implements IOOperation {

    Scanner s;
    
    @Override
    public void oper(Database database, User user) {
    s= new Scanner(System.in);
    System.out.println("Enter the name of the book");
    String str=s.next();
    int i=database.getBooksName(str);
    if (i>-1) {
        Books book= database.getBook(i);
        System.out.println(book);
        
    }
    else
    {
        System.out.println("Book doesnot exists");
    }
    user.menu(database, user);
   
    }

    
}
