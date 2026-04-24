package CoreJava.LMS.Library;

import java.util.Scanner;

public class Exit implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
        s= new Scanner(System.in);
        System.out.println("Are you sure you want to exit\n 1.Proceed\n 2.Main menu");
        int num=s.nextInt();

       switch (num) {
        case 1:
            break;
       
        default:

            user.menu(database, user);
        
       }
    
    }
    
}
