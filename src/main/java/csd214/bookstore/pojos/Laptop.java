package csd214.bookstore.pojos;

import java.util.Scanner;

public class Laptop extends Electronics {
    private double screenSize;

    public Laptop(String brand, double price, int warrantyMonths, double screenSize) {
        super(brand, price, warrantyMonths);
        this.screenSize = screenSize;
    }

    public Laptop() {
        super("Unknown", 0.0, 0);
        this.screenSize = 0.0;
    }

    public Laptop(Scanner input) {
        super(input);
        System.out.print("Enter screen size: ");
        this.screenSize = Double.parseDouble(input.nextLine());
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter screen size: ");
        this.screenSize = Double.parseDouble(input.nextLine());
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Edit screen size (current: " + screenSize + "\"): ");
        this.screenSize = Double.parseDouble(input.nextLine());
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.screenSize, screenSize) == 0 &&
                getBrand().equals(laptop.getBrand()) &&
                getPrice() == laptop.getPrice() &&
                getWarrantyMonths() == laptop.getWarrantyMonths();
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(screenSize);
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + Double.hashCode(getPrice());
        result = 31 * result + getWarrantyMonths();
        return result;
    }

    public double getScreenSize() { return screenSize; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
}