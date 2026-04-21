package CoreJava.LMS.Library;

import java.util.ArrayList;

public class Database
{
    ArrayList<User> users=new ArrayList<>();
    ArrayList<String> usernames= new ArrayList<>();

    public void addUser(User s)
    {
        users.add(s);
        usernames.add(s.getName());
    }
    
public boolean login(String phoneNumber, String email)
{
    boolean n= false;
    for(User s: users)
    {
        if(s.getPhoneNumber().matches(phoneNumber)&&s.getEmail().matches(email))
        {
            n=true;
            break;
        }
    }

    return n;
}

}
