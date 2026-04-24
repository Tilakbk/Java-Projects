package CoreJava.LMS.Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database
{
   private ArrayList<User> users=new ArrayList<>();
   private ArrayList<String> usernames= new ArrayList<>();
   private ArrayList<Books> books= new ArrayList<>();
   private ArrayList<String> booknames= new ArrayList<>();

//    private File userFile= new File(Main.class.getClassLoader().getResource("\\Users").getFile());
//    private File bookFile= new File(Main.class.getClassLoader().getResource("\\Books").getFile());
       private File userFile= new File("D:\\Java-Projects\\CoreJava\\LMS\\Data\\Users");
       private File booksFile= new File("D:\\Java-Projects\\CoreJava\\LMS\\Data\\Books");
       private File folder=new File("D:\\Java-Projects\\CoreJava\\LMS\\Data") ;


    public Database() 
    {
        if(!folder.exists())
        {
            folder.mkdirs();
        }

        if (!userFile.exists()) {
            try
            {userFile.createNewFile();}
            
            catch(IOException e)
            {
                System.err.println("e");
            }
        }

        if (!booksFile.exists()) {
            try
            {booksFile.createNewFile();}
            catch(IOException e)
            {
                System.err.println(e);
            }
            
        }
        getUsers();
        getBooks();
    }

    public void addUser(User s)
    {
        users.add(s);
        usernames.add(s.getName());
        saveUsers();
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
    saveBooks();
}

public void getUsers()
{
    String text1="";
    try {
        BufferedReader br1 = new BufferedReader(new FileReader(userFile));
        String s;
        while ((s=br1.readLine())!=null) {
            text1=text1+s;
            
        }
        br1.close();
    } 
    catch (Exception e) {
        System.err.println(e.toString());
    }

    if (!text1.matches("")|| !text1.isEmpty()) {
        String[] a1= text1.split("<NewUser/>");
        for (String s : a1) {
            String[] a2= s.split("<N/>");
            if (a2[3].matches("Admin")) {
                User user= new Admin(a2[0],a2[1],a2[2]);
                users.add(user);
                usernames.add(user.getName());
                
            }
            else
            {
                User user= new NormalUser(a2[0],a2[1],a2[2]);
                users.add(user);
                usernames.add(user.getName());
            }
            
        }
        
    }

}

    public void saveUsers()
    {
       String text1= "";
        for (User u: users ) {
            text1= text1+u.toString()+"<NewUser/>\n";
        }

        try (PrintWriter pw= new PrintWriter(userFile)) {
            pw.print(text1);
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

     public void saveBooks()
    {
       String text1= "";
        for (Books b: books ) {
            text1= text1+b.toString2()+"<NewBook/>\n";
        }

        try (PrintWriter pw= new PrintWriter(booksFile)) {
            pw.print(text1);
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    public void getBooks()
{
    String text1="";
    try {
        BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
        String s;
        while ((s=br1.readLine())!=null) {
            text1=text1+s;
            
        }
        br1.close();
    } 
    catch (Exception e) {
        System.err.println(e.toString());
    }

    if (!text1.matches("")|| !text1.isEmpty()) {
        String[] a1= text1.split("<NewBook/>");
        for (String s : a1) {
            
            Books book= parseBook(s);
            books.add(book);
            booknames.add(book.getName());



            
        }
        
    }

}

 public Books parseBook(String s)
    {
        String[] a= s.split("<N/>");
        Books book = new Books();
        book.setName(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setAddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setBrwcopies(Integer.parseInt(a[6]));

        return book;



    }

    public ArrayList<Books> getAllBooks()
    {
        return books;
    }

    public int getBooksName(String bookname)
    {
        int i=-1;
        for ( String bn : booknames ) {
            if (bn.matches(bookname))
            {
                i= booknames.indexOf(bn);
            }

            
        }
        
        return i;


    }

    public Books getBook(int i)
    {
        return (books.get(i));
    }

    public void deleteBook(int i)
    {
        books.remove(i);
        booknames.remove(i);
    }

}
