import java.util.ArrayList;
import java.util.Comparator;

class Goodies {
    private double price;
    
    public Goodies(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Goodies goodies = (Goodies) obj;
        return Double.compare(goodies.price, price) == 0;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Bag {
}

class CandyBags extends Bag {
    private ArrayList<Goodies> goodiesList;

    public CandyBags() {
        goodiesList = new ArrayList<>();
    }

    public void add(Goodies goodies) {
        if (!goodiesList.contains(goodies)) {
            goodiesList.add(goodies);
        }
    }

    public Goodies cheapest() {
        return goodiesList.stream()
                          .min(Comparator.comparing(Goodies::getPrice))
                          .orElse(null);
    }

    public CandyBags mostExpensive(int n) {
        CandyBags expensiveBags = new CandyBags();
        goodiesList.stream()
                   .sorted(Comparator.comparing(Goodies::getPrice).reversed())
                   .limit(n)
                   .forEach(expensiveBags::add);
        return expensiveBags;
    }
    
    public ArrayList<Goodies> getGoodiesList() {
        return goodiesList;
    }
}

