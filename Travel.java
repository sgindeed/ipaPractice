import java.util.*;

class Travel{
    private int regNo;
    private String name;
    private String packageType;
    private int price;
    private boolean flight;
    
    public Travel(int regNo, String name, String packageType, int price, boolean flight){
        this.regNo = regNo;
        this.name = name;
        this.packageType = packageType;
        this.price = price;
        this.flight = flight;
    }
    
    public int getRegNo(){
        return regNo;
    }
    public void setRegNo(int regNo){
        this.regNo = regNo;
    }
    
    public String getName() {
    return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPackageType() {
        return packageType;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public boolean getFlight() {
        return flight;
    }
    public void setFlight(boolean flight) {
        this.flight = flight;
    }
}


class Main{
    public static int findAgencyWithHighestPackagePrice(Travel[] arr){
        int maxPack = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].getPrice() > maxPack)
                maxPack = arr[i].getPrice();
        }
        return maxPack;
    }
    
    public static Travel agencyDetailsForGivenldAndType(Travel[] arr, int findreg, String findpack){
            for(int i=0; i<arr.length; i++){
                if(arr[i].getFlight()){
                    if(arr[i].getRegNo() == findreg && arr[i].getPackageType().equalsIgnoreCase(findpack))
                        return arr[i];
                }
            }
            return null;
    }
    
    public static void main (String[] args) {
        Scanner se = new Scanner(System.in);
        Travel[] arr = new Travel[4];
        for(int i=0; i<4; i++){
            int regNo = se.nextInt();
            se.nextLine();
            String name = se.nextLine();
            String packageType = se.nextLine();
            int price = se.nextInt();
            se.nextLine();
            boolean flight = se.nextBoolean();
            se.nextLine();
            arr[i] = new Travel(regNo, name, packageType, price, flight);
        }
        int findreg = se.nextInt();
        se.nextLine();
        String findpack = se.nextLine();
        
        System.out.println(findAgencyWithHighestPackagePrice(arr));
        
        Travel result = agencyDetailsForGivenldAndType(arr, findreg, findpack);
        System.out.println(result.getName() + ":" + result.getPrice());
    }
}
