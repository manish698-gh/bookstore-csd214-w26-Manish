package csd214.bookstore.pojos;

import java.util.Scanner;

public class Smartphone extends Electronics {
    private int cameraMP;

    public Smartphone(String brand, double price, int warrantyMonths, int cameraMP) {
        super(brand, price, warrantyMonths);
        this.cameraMP = cameraMP;
    }

    public Smartphone() {
        super("Unknown", 0.0, 0);
        this.cameraMP = 12;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter camera megapixels: ");
        this.cameraMP = getInput(input, 12);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Edit camera megapixels (current: " + cameraMP + "): ");
        this.cameraMP = getInput(input, this.cameraMP);
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
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return cameraMP == that.cameraMP;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cameraMP;
        return result;
    }

    public int getCameraMP() {
        return cameraMP;
    }

    public void setCameraMP(int cameraMP) {
        this.cameraMP = cameraMP;
    }

    @Override
    public String toString() {
        return "Smartphone[" +
                "brand='" + getBrand() + '\'' +
                ", price=$" + String.format("%.2f", getPrice()) +
                ", warranty=" + getWarrantyMonths() + " months" +
                ", camera=" + cameraMP + "MP" +
                ", copies=" + getCopies() +
                ']';
    }
}