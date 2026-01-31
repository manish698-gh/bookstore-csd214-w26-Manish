package csd214.bookstore.pojos;

import java.util.Scanner;

public class Notebook extends Stationery {
    private int pageCount;

    public Notebook(String brand, int pageCount, double price) {
        super(brand, price);
        this.pageCount = pageCount;
    }

    public Notebook() {
        super("Unknown", 0.0);
        this.pageCount = 0;
    }

    public Notebook(Scanner input) {
        super(input);
        System.out.print("Enter page count: ");
        this.pageCount = Integer.parseInt(input.nextLine());
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter page count: ");
        this.pageCount = Integer.parseInt(input.nextLine());
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Edit page count (current: " + pageCount + "): ");
        this.pageCount = Integer.parseInt(input.nextLine());
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
        Notebook that = (Notebook) o;
        return pageCount == that.pageCount &&
                getBrand().equals(that.getBrand()) &&
                getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        int result = pageCount;
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + Double.hashCode(getPrice());
        return result;
    }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
}