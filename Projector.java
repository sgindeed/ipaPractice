import java.util.*;

public class Main
{
    public static Projector findMaxPriceByRating(Projector[] projectors, int givenRating){
        
        int maxPrice = Integer.MIN_VALUE;
        Projector maxPriceProjector = null;
        for(Projector projector : projectors){
            if(projector.getRating() > givenRating && projector.getSite().equalsIgnoreCase("TataCliq")){
                if(projector.getPrice() > maxPrice){
                    maxPrice = projector.getPrice();
                    maxPriceProjector = projector;
                }
            }
        }
        return maxPriceProjector;
        
    }
	public static void main(String[] args) {
		Scanner se = new Scanner(System.in);
		int n = se.nextInt();
		Projector[] projectors = new Projector[n];
		for(int i=0; i<n; i++){
		    int id = se.nextInt();
		    se.nextLine();
		    String name = se.nextLine();
		    int price = se.nextInt();
		    se.nextLine();
		    int rating = se.nextInt();
		    se.nextLine();
		    String site = se.nextLine();
		    projectors[i] = new Projector(id, name, price, rating, site);
		}
		
		int givenRating = se.nextInt();
		se.nextLine();
		
		Projector resultProjector = findMaxPriceByRating(projectors, givenRating);
		
		if(resultProjector != null)
		    System.out.println(resultProjector.getId());
	}
}

class Projector{
    private int id;
    private String name;
    private int price;
    private int rating;
    private String site;
    
    public Projector(int id, String name, int price, int rating, String site){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.site = site;
    }
    
    public int getId() {
    return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getSite() {
        return site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
}
