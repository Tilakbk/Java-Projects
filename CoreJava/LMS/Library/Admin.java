package CoreJava.LMS.Library;
import java.util.Scanner;

public class Admin extends User
{
    public Admin(String name)
    {
        super(name);
         this.operations= new IOOperation[]
        {
            new ViewBooks(), new AddBook(), new DeleteBooks(),new Search(),new Erase(), new ViewOrder(),new Exit()
        };
    }

    public Admin(String name,String email, String phoneNumber)
    {
        super(name,email,phoneNumber);
        this.operations= new IOOperation[]
        {
            new ViewBooks(), new AddBook(), new DeleteBooks(),new Search(),new Erase(), new ViewOrder(),new Exit()
        };
    }

    @Override
    public void menu(Database database, User user)
    {
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search");
        System.out.println("5. Erase");
        System.out.println("6. View order");
        System.out.println("7. Exit");

        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        n--;
        this.operations[n].oper(database,user);
       
    }

    @Override
    public String toString() {
      return (name+"<N/>"+email+"<N/>"+phoneNumber+"<N/>"+"Admin");
    }

    
}