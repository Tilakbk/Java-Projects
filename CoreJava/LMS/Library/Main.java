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
                case 0:
                    break;
                case 1:
                    login();
                    
                    break;
                case 2:
                    newUser();
                    break;
            
                default:
                    System.out.println("Enter a valid number");
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
                user.menu(db,user);
               
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
            User user;
            if(n==1)
            {
            
                user= new Admin(name,email,phoneNumber);
                
            }
            

            else
            {
                user= new NormalUser(name, email, phoneNumber);
                
            }
            db.addUser(user);
             System.out.println("User created successfully");
            user.menu(db,user);
           
        }

    
}