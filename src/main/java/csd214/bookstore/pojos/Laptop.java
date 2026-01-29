package csd214.bookstore.pojos;

public class Laptop extends Electronics {
    private double screenSize;

    public double getScreenSize() { return screenSize; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }

    @Override
    public void initialize() {
        super.initialize();  // Gets warranty AND price from Electronics
        System.out.println("Enter Screen Size (inches):");
        this.screenSize = getInput(15.6);
    }

    @Override
    public void edit() {
        super.edit();  // Edits warranty AND price from Electronics
        System.out.println("Edit Screen Size (inches):");
        this.screenSize = getInput(this.screenSize);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Laptop with " + screenSize + "\" screen for $" +
                String.format("%.2f", getPrice()) + "...");
    }

    @Override
    public String toString() {
        return "Laptop{screenSize=" + screenSize +
                "\", warranty=" + getWarrantyMonths() + " months" +
                ", price=$" + String.format("%.2f", getPrice()) + "}";
    }
}