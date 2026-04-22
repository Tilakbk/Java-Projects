package CoreJava.LMS.Library;



public class Books {
    private String name;
    private String author;
    private String publisher;
    private String address;
    private String status;
    private int qty;
    private double price;
    private int brwcopies;

    public Books(String name, String author, String publisher, String   address, String status, int qty,
            double price,int brwcopies) 
    {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.address = address;
        this.status = status;
        this.qty = qty;
        this.price=price;
        this.brwcopies = brwcopies;
    }

    public String toString()
    {
        String text ="Name:"+name+" author:"+author+" publisher:"+publisher+" address:"+address+" status:"+status+"     Quantity:"+String.valueOf(qty)+" price:"+String.valueOf(price)+" Borrow copies: "+String.valueOf(brwcopies);
        
        return text;    
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public int getBrwcopies() {
        return brwcopies;
    }

    

    
    
}
