package csd214.bookstore.pojos;

public class Smartphone extends Electronics {
    private int cameraMP;

    public int getCameraMP() { return cameraMP; }
    public void setCameraMP(int cameraMP) { this.cameraMP = cameraMP; }

    @Override
    public void initialize() {
        super.initialize();  // Gets warranty AND price from Electronics
        System.out.println("Enter Camera Megapixels:");
        this.cameraMP = getInput(12);
    }

    @Override
    public void edit() {
        super.edit();  // Edits warranty AND price from Electronics
        System.out.println("Edit Camera Megapixels:");
        this.cameraMP = getInput(this.cameraMP);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Smartphone with " + cameraMP + "MP camera for $" +
                String.format("%.2f", getPrice()) + "...");
    }

    @Override
    public String toString() {
        return "Smartphone{camera=" + cameraMP + "MP" +
                ", warranty=" + getWarrantyMonths() + " months" +
                ", price=$" + String.format("%.2f", getPrice()) + "}";
    }
}