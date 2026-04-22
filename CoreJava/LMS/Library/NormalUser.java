package CoreJava.LMS.Library;
import java.util.Scanner;

public class NormalUser extends User 
{
    public NormalUser(String name)
    {
        super(name);
        this.operations= new IOOperation[]
        {
            new ViewBooks(),new Search(), new PlaceOrder(), new BorrowBook(),new CalculateFine(),new ReturnBook(), new Exit()
        };
    }
    
    public NormalUser(String name, String email,String phoneNumber)
    {
        super(name,email,phoneNumber);
         this.operations= new IOOperation[]
        {
            new ViewBooks(),new Search(), new PlaceOrder(), new BorrowBook(),new CalculateFine(),new ReturnBook(), new Exit()
        };
    }

    @Override
    public void menu()
    {
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        n--;
        this.operations[n].oper();
        

    }
}
