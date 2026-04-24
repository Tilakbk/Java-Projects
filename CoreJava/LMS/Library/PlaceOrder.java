package CoreJava.LMS.Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation{
    Scanner s;
    Order o=new Order();

    @Override
    public void oper(Database database, User user) {
       System.out.println("Enter the books name you want order");
       s=new Scanner(System.in);
       String bname=s.next();
       
       int i= database.getBooksName(bname);
       
       if (i>-1) {
        o.setBook(database.getBook(i));
        o.setUser(user);
        System.out.println("Enter Quantity");
        int qty=s.nextInt();
        o.setQty(qty);
        
        o.setPrice(o.getPrice()*qty);
        database.addOrder(o);
        System.out.println("Ordered placed");
        
       }
       else
       {
        System.out.println("Book doesnot exists");
       }
    }
    
}
