package csd214.bookstore.pojos;

public class Notebook extends Stationery {
    private int pageCount;

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    @Override
    public void initialize() {
        super.initialize();  // This now calls Stationery.initialize() which gets brand AND price
        System.out.println("Enter Page Count:");
        this.pageCount = getInput(100);
    }

    @Override
    public void edit() {
        super.edit();  // This now calls Stationery.edit() which edits brand AND price
        System.out.println("Edit Page Count:");
        this.pageCount = getInput(this.pageCount);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Notebook with " + pageCount + " pages for $" + getPrice() + "...");
    }

    @Override
    public String toString() {
        return "Notebook{pages=" + pageCount +
                ", brand='" + getBrand() + "'" +
                ", price=$" + String.format("%.2f", getPrice()) + "}";
    }
}