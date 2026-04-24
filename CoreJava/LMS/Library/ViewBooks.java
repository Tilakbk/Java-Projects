package CoreJava.LMS.Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation 
{

    @Override
    public void oper(Database database, User user)
    {
       ArrayList<Books> book= database.getAllBooks();
       System.out.println(" Book Name\tAuthor name\tPublisher\tCollection book Address\tBook Quantity\tBook price\tBorrowed copies");

       for (Books b: book ) {
        {
            System.out.println(b.getName()+"\t"+b.getAuthor()+"\t"+b.getPublisher()+"\t"+b.getAddress()+"\t"+b.getPrice()+"\t"+b.getPrice()+"\t"+b.getBrwcopies());
        }
        
       }

       user.menu(database,user);
        
    }

    
}
