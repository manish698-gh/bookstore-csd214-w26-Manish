package csd214.bookstore.pojos;

import java.util.Scanner;

public abstract class Stationery extends Product {
    private String brand;
    private double price;
    private int copies;

    public Stationery(String brand, double price) {
        this.brand = brand;
        this.price = price;
        this.copies = 0;
    }

    public Stationery(Scanner input) {
        initialize(input);
    }

    @Override
    public void initialize(Scanner input) {
        System.out.print("Enter brand: ");
        this.brand = input.nextLine();
        System.out.print("Enter price: ");
        this.price = Double.parseDouble(input.nextLine());
        System.out.print("Enter copies: ");
        this.copies = Integer.parseInt(input.nextLine());
    }

    @Override
    public void edit(Scanner input) {
        System.out.print("Edit brand (current: " + brand + "): ");
        this.brand = input.nextLine();
        System.out.print("Edit price (current: " + price + "): ");
        this.price = Double.parseDouble(input.nextLine());
        System.out.print("Edit copies (current: " + copies + "): ");
        this.copies = Integer.parseInt(input.nextLine());
    }

    @Override
    public void sellItem() {
        if (copies > 0) {
            copies--;
        }
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
        int result = brand.hashCode();
        result = 31 * result + Double.hashCode(price);
        return result;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
}