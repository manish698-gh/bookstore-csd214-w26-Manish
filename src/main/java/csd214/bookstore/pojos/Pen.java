package csd214.bookstore.pojos;

import java.util.Scanner;

public class Pen extends Stationery {
    private String color;

    public Pen(String brand, String color, double price) {
        super(brand, price);
        this.color = color;
    }

    public Pen() {
        super("Unknown", 0.0);
        this.color = "Unknown";
    }

    public Pen(Scanner input) {
        super(input);
        System.out.print("Enter color: ");
        this.color = input.nextLine();
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter color: ");
        this.color = input.nextLine();
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Edit color (current: " + color + "): ");
        this.color = input.nextLine();
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
        Pen pen = (Pen) o;
        return color.equals(pen.color) &&
                getBrand().equals(pen.getBrand()) &&
                getPrice() == pen.getPrice();
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + Double.hashCode(getPrice());
        return result;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}