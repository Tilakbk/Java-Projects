package CoreJava.LMS;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        System.out.println("Welcome to Library management System\n"+"1.Login\n"+"2. Create account");

        Scanner s= new Scanner(System.in);
        int n= s.nextInt();

        switch (n) {
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
}