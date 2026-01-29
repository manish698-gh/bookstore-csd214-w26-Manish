package csd214.bookstore.pojos;

public abstract class Stationery extends Product {
    private String brand;
    private double price;  // ADD THIS FIELD

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    // ADD getPrice() implementation
    @Override
    public double getPrice() {
        return price;
    }

    // ADD setPrice() method
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void initialize() {
        // super.initialize();  // Keep commented if Product.initialize() doesn't exist
        System.out.println("Enter Brand:");
        this.brand = getInput("Generic");
        System.out.println("Enter Price:");
        this.price = getInput(0.0);  // ADD THIS LINE
    }

    @Override
    public void edit() {
        // super.edit();  // Keep commented if Product.edit() doesn't exist
        System.out.println("Edit Brand:");
        this.brand = getInput(this.brand);
        System.out.println("Edit Price:");
        this.price = getInput(this.price);  // ADD THIS LINE
    }

    // REMOVE the old getPrice() that returns 0.0
    // @Override
    // public double getPrice() {
    //     return 0.0; // We must add price field
    // }

    @Override
    public String toString() {
        return "Stationery[brand=" + brand + ", price=$" + String.format("%.2f", price) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Stationery)) return false;
        Stationery that = (Stationery) obj;
        return brand.equals(that.brand) && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + Double.hashCode(price);
        return result;
    }
}