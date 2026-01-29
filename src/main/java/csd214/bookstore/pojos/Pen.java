package csd214.bookstore.pojos;

public class Pen extends Stationery {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Color:");
        this.color = getInput("Blue");
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Color:");
        this.color = getInput(this.color);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + color + " Pen for $" +
                String.format("%.2f", getPrice()) + "...");
    }

    @Override
    public String toString() {
        return "Pen[color=" + color +
                ", brand=" + getBrand() +
                ", price=$" + String.format("%.2f", getPrice()) + "]";
    }
}