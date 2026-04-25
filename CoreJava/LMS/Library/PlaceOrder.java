package CoreJava.LMS.Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation{
    Scanner s;
    Order o=new Order();

    @Override
public void oper(Database database, User user) {
    System.out.println("Enter the books name you want order");
    s = new Scanner(System.in);
    String bname = s.next();
    
    int i = database.getBooksName(bname);
    
    if (i > -1) {
        
        Books book = database.getBook(i); 
        
        o.setBook(book);
        o.setUser(user);
        
        System.out.println("Enter Quantity");
        int qty = s.nextInt();
        
        
        if (qty <= book.getQty()) {
            o.setQty(qty);
            o.setPrice(book.getPrice() * qty); 
            
            
            book.setQty(book.getQty() - qty);
            
            
            database.addOrder(o, book, i); 
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Not enough stock available.");
        }
    } else {
        System.out.println("Book does not exist");
    }

    user.menu(database, user);
}
    // @Override
    // public void oper(Database database, User user) {
    //    System.out.println("Enter the books name you want order");
    //    s=new Scanner(System.in);
    //    String bname=s.next();
       
    //    int i= database.getBooksName(bname);
       
    //    if (i>-1) {
    //     Books book= new Books();
    //     o.setBook(database.getBook(i));
    //     o.setUser(user);
    //     System.out.println("Enter Quantity");
    //     int qty=s.nextInt();
    //     o.setQty(qty);
        
    //     o.setPrice(o.getPrice()*qty);
    //     int bookindex= database.getBooksName(book.getName());
    //     book.setQty(book.getQty()-qty);
    //     database.addOrder(o,book,bookindex);
    //     System.out.println("Ordered placed");
        
    //    }
    //    else
    //    {
    //     System.out.println("Book doesnot exists");
    //    }

    //    user.menu(database, user);
    // }
    
}
