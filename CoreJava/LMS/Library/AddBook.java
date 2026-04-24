package CoreJava.LMS.Library;

import java.util.Scanner;

public class AddBook implements IOOperation 
{
    public void oper(Database database, User user)
    {
              Scanner s=new Scanner(System.in);
              Books book= new Books();
              System.out.println("Enter Book name");
              book.setName(s.next());
              System.out.println("Enter author name");
              book.setAuthor(s.next());
              System.out.println("Enter publisher");
              book.setPublisher(s.next());
              System.out.println("Enter collection address");
              book.setAddress(s.next());
            
              System.out.println("Enter quantity of book");
              book.setQty(s.nextInt());
              System.out.println("Enter price of book");
              book.setPrice(s.nextDouble());
              System.out.println("Enter borrow quantity");
              book.setBrwcopies(s.nextInt());
              

              database.addBooks(book);
              System.out.println("Book added successfully");
            
              user.menu(database, user);

    }

}
