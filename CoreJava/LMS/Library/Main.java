package CoreJava.LMS.Library;
import java.util.Scanner;

public class Main
{
    static Scanner s;
    static Database db;
    public static void main(String args[])
    {
        db= new Database();
        int n;
        do
        {
            System.out.println("Welcome to Library management System\n"+"0.Exit\n"+"1.Login\n"+"2.Create account");

            s= new Scanner(System.in);
            n= s.nextInt();

            switch (n) 
            {
                case 1:
                    login();
                    
                    break;
                case 2:
                    newUser();
            
                default:
                  
                    break;
            }
        } while (n!=0);
        

    
    }

    public static void login()
        {
            System.out.println("Enter your phone number");
            String phoneNumber= s.next();

            System.out.println("Enter your email");
            String email= s.next();
            int n= db.login(phoneNumber, email);
            if(n!=-1)
            {
                User user= db.getUser(n);
                System.out.println("Welcome: "+user.getName());
            }
            else
            {
                System.out.println("Login failed");
                return;
            }
        }
    
    public static void newUser()
        {
            System.out.println("Enter your name");
            String name= s.next();

            System.out.println("Enter your email");
            String email= s.next();
            
            System.out.println("Enter your phone number");
            String phoneNumber= s.next();

            System.out.println("1. Admin\n"+ "2. Normal user");
            int n=s.nextInt();
            if(n==1)
            {
            
                User admin= new Admin(name,email,phoneNumber);
                db.addUser(admin);
            }
            

            else
            {
                User normalUser= new NormalUser(name, email, phoneNumber);
                db.addUser(normalUser);
            }
            System.out.println("User created successfully");
        }

    
}