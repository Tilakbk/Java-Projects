package CoreJava.LMS.Library;
import java.util.Scanner;
import java.util.ArrayList;
public class ViewOrder implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
        s=new Scanner(System.in);

        System.out.println("Enter the books name");
        String str=s.next();

        int i=database.getBooksName(str);

        if (i>-1) {
            

            for (Order o :database.getAllOrder()) {
                if (o.getBook().getName().matches(str)) {
                    System.out.println(o.getBook().getName()+"\t\t"+
                    o.getUser().getName()+"\t\t"+o.getQty()+"\t\t"+o.getPrice());
                    
                }


                
            }
            
        }
        else
            System.out.println("Book doesnot exists");

        user.menu(database, user);
    }
    
    
}
