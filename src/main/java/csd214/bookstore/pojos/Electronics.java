package csd214.bookstore.pojos;

public abstract class Electronics extends Product {
    private int warrantyMonths;
    private double price;

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }


    @Override
    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void initialize() {
        System.out.println("Enter Warranty (months):");
        this.warrantyMonths = getInput(12);
        System.out.println("Enter Price:");  // ADD THIS
        this.price = getInput(0.0);  // ADD THIS
    }

    @Override
    public void edit() {
        System.out.println("Edit Warranty (months):");
        this.warrantyMonths = getInput(this.warrantyMonths);
        System.out.println("Edit Price:");  // ADD THIS
        this.price = getInput(this.price);  // ADD THIS
    }


    @Override
    public String toString() {
        return "Electronics[warranty=" + warrantyMonths +
                " months, price=$" + String.format("%.2f", price) + "]";
    }
}