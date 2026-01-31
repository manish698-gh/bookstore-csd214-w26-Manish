package csd214.bookstore.pojos;

import java.util.Scanner;

public abstract class Electronics extends Product {
    private String brand;
    private double price;
    private int warrantyMonths;
    private int copies;

    public Electronics(String brand, double price, int warrantyMonths) {
        this.brand = brand;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.copies = 0;
    }

    public Electronics(Scanner input) {
        initialize(input);
    }

    @Override
    public void initialize(Scanner input) {
        System.out.print("Enter brand: ");
        this.brand = input.nextLine();
        System.out.print("Enter price: ");
        this.price = Double.parseDouble(input.nextLine());
        System.out.print("Enter warranty months: ");
        this.warrantyMonths = Integer.parseInt(input.nextLine());
        System.out.print("Enter copies: ");
        this.copies = Integer.parseInt(input.nextLine());
    }

    @Override
    public void edit(Scanner input) {
        System.out.print("Edit brand (current: " + brand + "): ");
        this.brand = input.nextLine();
        System.out.print("Edit price (current: " + price + "): ");
        this.price = Double.parseDouble(input.nextLine());
        System.out.print("Edit warranty months (current: " + warrantyMonths + "): ");
        this.warrantyMonths = Integer.parseInt(input.nextLine());
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
        if (!(obj instanceof Electronics)) return false;
        Electronics that = (Electronics) obj;
        return brand.equals(that.brand) &&
                Double.compare(that.price, price) == 0 &&
                warrantyMonths == that.warrantyMonths;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + warrantyMonths;
        return result;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
}