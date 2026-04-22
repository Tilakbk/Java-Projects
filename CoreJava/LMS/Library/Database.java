package CoreJava.LMS.Library;

import java.io.File;
import java.util.ArrayList;

public class Database
{
   private ArrayList<User> users=new ArrayList<>();
   private ArrayList<String> usernames= new ArrayList<>();
   private ArrayList<Books> books= new ArrayList<>();
   private ArrayList<String> booknames= new ArrayList<>();

   private File userFile= new File(Main.class.getClassLoader().getResource("Users").getFile());
   private File bookFile= new File(Main.class.getClassLoader().getResource("Books").getFile());

    public Database()
    {
        if(!userFile.exists())
        {
            userFile.mkdirs();
        }

        if (!bookFile.exists()) {
            bookFile.mkdirs();            
        }
    }

    public void addUser(User s)
    {
        users.add(s);
        usernames.add(s.getName());
    }
    
public int login(String phoneNumber, String email)
{
    int n= -1;
    for(User s: users)
    {
        if(s.getPhoneNumber().matches(phoneNumber)&&s.getEmail().matches(email))
        {
            n=users.indexOf(s);
            break;
        }
    }

    return n;
}

public User getUser(int n)
{
    return users.get(n);
}

public void addBooks(Books book)
{
    books.add(book);
    booknames.add(book.getName());
}
}
