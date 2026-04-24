package CoreJava.LMS.Library;
import java.util.Scanner;

public class DeleteBooks implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
        s= new Scanner(System.in);
        System.out.println ("Enter the books name");
         String str=s.next();

         int i= database.getBooksName( str);

         if (i>-1) {

            database.deleteBook(i);
            System.out.println("Book deleted successfully");
            
         }
         else
         {
            System.out.println("Book doesnot exists");
         }

         user.menu(database, user);

    
    }

    
}
