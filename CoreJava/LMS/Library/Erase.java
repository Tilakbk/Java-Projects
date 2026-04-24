package CoreJava.LMS.Library;

import java.util.Scanner;

public class Erase implements IOOperation {

    Scanner s;
    @Override
    public void oper(Database database, User user) {
        
        s= new Scanner(System.in);
        System.out.println("Are you sure you want to erase all data\n 1.Proceed\n 2.Main menu");
        int num=s.nextInt();

        if (num==1) {
            database.deleteAllData();
            
        }
        else
        {
            user.menu(database, user);
        }

       
    }
    
}
