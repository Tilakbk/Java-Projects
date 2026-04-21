package CoreJava.LMS;
import CoreJava.LMS.Library.*;

import java.util.Scanner;

public class Main
{
    static Scanner s;
    public static void main(String args[])
    {
        System.out.println("Welcome to Library management System\n"+"1.Login\n"+"2. Create account");

        Scanner s= new Scanner(System.in);
        int n= s.nextInt();

        switch (n) 
        {
            case 1:
                login();
                
                break;
            case 2:
                newUser();
        
            default:
                System.out.println("Enter valid option");
                break;
        }

       
    }

    public static void login()
        {
            System.out.println("Enter your phone number");
            String phoneNumber= s.next();

            System.out.println("Enter your email");
            String email= s.next();
        }
    
        public static void newUser()
        {
            System.out.println("Enter your name");
            String name= s.nextLine();

            System.out.println("Enter your email");
            String email= s.next();
            
            System.out.println("Enter your phone number");
            String phoneNumber= s.next();

            System.out.println("1. Admin\n"+ "2. Normal user");
            int n=s.nextInt();
            if(n==2)
            {
                
            }

            else
            {
                
            }
        }
     

    
}