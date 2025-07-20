import java.util.*;

class Headset {
    private String name;
    private String brand;
    private int price;
    private boolean available;

    public Headset(String name, String brand, int price, boolean available) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

public class Main {

    public static Headset[] findPriceForGivenBrand(Headset[] headsets, String givenBrand) {
        ArrayList<Headset> headList = new ArrayList<>();
        for (Headset headset : headsets) {
            if (headset.getBrand().equalsIgnoreCase(givenBrand)) {
                headList.add(headset);
            }
        }
        return headList.toArray(new Headset[0]);
    }

    public static Headset findSecondMinPrice(Headset[] headsets) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        Headset secondMinHeadset = null;

        for (Headset headset : headsets) {
            int price = headset.getPrice();
            if (price < min) {
                secMin = min;
                min = price;
            } else if (price > min && price < secMin) {
                secMin = price;
                secondMinHeadset = headset;
            }
        }
        return secondMinHeadset;
    }

    public static void main(String[] args) {
        Scanner se = new Scanner(System.in);
        Headset[] headsets = new Headset[4];

        for (int i = 0; i < 4; i++) {
            String name = se.nextLine();
            String brand = se.nextLine();
            int price = Integer.parseInt(se.nextLine());
            boolean available = Boolean.parseBoolean(se.nextLine());
            headsets[i] = new Headset(name, brand, price, available);
        }

        String givenBrand = se.nextLine();

        Headset[] priceBrand = findPriceForGivenBrand(headsets, givenBrand);

        if (priceBrand.length > 0) {
            for (Headset result : priceBrand) {
                System.out.println(result.getPrice());
            }
        } else {
            System.out.println("No headset");
        }

        Headset secondMin = findSecondMinPrice(headsets);
        if (secondMin != null) {
            System.out.println(secondMin.getName());
            System.out.println(secondMin.getBrand());
        } else {
            System.out.println("No second minimum price headset found");
        }
    }
}
