import java.util.*;

class Main{
    
    public static void main(String[] args){
        
        Scanner se = new Scanner(System.in);
        int n = se.nextInt();
        
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int authorid = se.nextInt();
            se.nextLine();
            String authorname = se.nextLine();
            
            Author author = new Author(authorid, authorname);
            
            int bookid = se.nextInt();
            se.nextLine();
            String title = se.nextLine();
            String genre = se.nextLine();
            double price = se.nextDouble();
            se.nextLine();
            
            Book book = new Book(bookid, title, genre, price, author);
            authors.add(author);
            books.add(book);
        }
        
        String genresearch = se.nextLine();
        String discgen = se.nextLine();
        double discountPercentage = se.nextDouble();
        se.nextLine();
        
        List<Book> bookbygen = getBooksBelongingToAGenre(books, genresearch);
        List<Book> bookbydisc = calculateDiscountedPrice(books, discgen, discountPercentage);
        
        if(!bookbygen.isEmpty()){
            for(int i=0; i<bookbygen.size(); i++){
                System.out.println("AuthorName: " + bookbygen.get(i).getAuthor().getAuthorName() + ". Title: " + bookbygen.get(i).getTitle());
            }
        }
        else
            System.out.println("Genre is not available in the list.");
            
        if(!bookbydisc.isEmpty()){
            System.out.println("Discounted " + discgen + " Books: ");
            for(int i=0; i<bookbydisc.size(); i++){
                System.out.println("AuthorName: " + bookbydisc.get(i).getAuthor().getAuthorName() + ", Title: " + bookbydisc.get(i).getTitle());
            }
        }
            else
                System.out.println("Discounted books are unavailable in the given genre.");
    }
    
    public static List<Book> getBooksBelongingToAGenre(List<Book> bookList, String genresearch){
        List<Book> bookres = new ArrayList<>();
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getGenre().equalsIgnoreCase(genresearch))
                bookres.add(bookList.get(i));
        }
        return bookres;
    }
    
    public static List<Book> calculateDiscountedPrice(List<Book> bookList, String discgenre, double discountPercentage){
        List<Book> disclist = new ArrayList<>();
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getGenre().equalsIgnoreCase(discgenre)){
                double newprice = bookList.get(i).getPrice() - (bookList.get(i).getPrice() * discountPercentage / 100);
                bookList.get(i).setPrice(newprice);
                disclist.add(bookList.get(i));
            }
        }
        return disclist;
    }
}

class Author{
    private int authorid;
    private String authorname;
    
    public Author(int authorid, String authorname){
        this.authorid = authorid;
        this.authorname = authorname;
    }
    
    public int getAuthorid(){
        return authorid;
    }
    
    public void setAuthorid(int authorid){
        this.authorid = authorid;
    }
    
    public String getAuthorName(){
        return authorname;
    }
    
    public void setAuthorname(String authorname){
        this.authorname = authorname;
    }
}


class Book{
    private int bookid;
    private String title;
    private String genre;
    private double price;
    private Author author;
    
    public Book(int bookid, String title, String genre, double price, Author author){
        this.bookid = bookid;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }
    
    public int getBookid(){
        return bookid;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
    }
    public double getPrice(){
        return price;
    }
    public Author getAuthor(){
        return author;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
