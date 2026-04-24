package CoreJava.LMS.Library;



public class Books {
    private String name;
    private String author;
    private String publisher;
    private String address;
   
    private int qty;
    private double price;
    private int brwcopies;

    public Books()
    {

    }
    public Books(String name, String author, String publisher, String   address, String status, int qty,
            double price,int brwcopies) 
    {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.address = address;
        
        this.qty = qty;
        this.price=price;
        this.brwcopies = brwcopies;
    }

    public String toString()
    {
        String text ="Name:"+name+" author:"+author+" publisher:"+publisher+" address:"+address+" status:"+"     Quantity:"+String.valueOf(qty)+" price:"+String.valueOf(price)+" Borrow copies: "+String.valueOf(brwcopies);
        
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

   

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public int getBrwcopies() {
        return brwcopies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrwcopies(int brwcopies) {
        this.brwcopies = brwcopies;
    }

    
    public String toString2()
    {
        String text =name+"<N/>"+author+"<N/>"+publisher+"<N/>"+address+"<N/>"+String.valueOf(qty)+"<N/>"+String.valueOf(price)+"<N/>"+String.valueOf(brwcopies)+"<NewBook/>";
        
        return text;    
    }
    
   
    
}
