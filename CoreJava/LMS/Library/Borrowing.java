package CoreJava.LMS.Library;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Borrowing {
    LocalDate start;
    LocalDate finish;
    int daysleft;
    Books book;
    User user;
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public Borrowing(Books book,User user)
    {
        start=LocalDate.now();
        finish=start.plusDays(14);
        Period period= Period.between(start, finish);
        daysleft=period.getDays();
        this.book=book;
        this.user=user;
    }

    public Borrowing(LocalDate start, LocalDate finish, Books book, User user) {
        this.start = start;
        this.finish = finish;
        this.daysleft=Period.between(start, finish).getDays();
        this.book = book;
        this.user = user;
    }

    public String getStart()
    {
        return formatter.format(start);
    }
    public String getFinish()
    {
        return formatter.format(finish);
    }

    public int daysLeft()
    {
        return daysleft;
    }

    public User getUser()
    {
        return user;
    }
    public Books getBooks()
    {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String toString()
    {
        return ("Borrowing start:"+start+"\tEnd date:"+finish+"\tDays left:"+daysleft);
    }
}
