package CoreJava.LMS.Library;

public class Order
{
    private Books book;
    private User user;
    private double price;
    private int qty;

   
   

    public Order(Books book, User user, double price, int qty) {
        this.book = book;
        this.user = user;
        this.price = price;
        this.qty = qty;
    }

    public Order() {
        
    }

    


    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString()
    {
        return (" Book name:"+book.getName()+" User name:"+user.getName()+" Price of book:"+price+"Quantity: "+qty);
    }
    
    public String toString2()
    {
        String text =book.getName()+"<N/>"+user.getName()+"<N/>"+price+"<N/>"+qty;
        
        return text;    
    }
}