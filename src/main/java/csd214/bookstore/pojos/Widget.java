package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Widget extends Product {
    private String widgetName;
    private double price;

    public Widget() {
        setWidgetName("Default Widget Name");
        setPrice(0.0);
    }

    public Widget(String name, double price) {
        // Generate UUID for productId
        setProductId(UUID.randomUUID().toString());
        setWidgetName(name);
        setPrice(price);
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    // Required by Editable class (NO Scanner parameter!)
    @Override
    public void edit() {
        System.out.println("Enter Widget name (<"+getWidgetName()+">) : ");
        setWidgetName(getInput(getWidgetName()));

        System.out.println("Enter Widget price (<"+getPrice()+">) : ");
        setPrice(getInput(getPrice()));
    }

    // Required by Editable class (NO Scanner parameter!)
    @Override
    public void initialize() {
        System.out.println("Enter Widget name (<Default Widget Name>) : ");
        setWidgetName(getInput("Default Widget Name"));

        System.out.println("Enter Widget price (<0>) : ");
        setPrice(getInput(0.0));

        // Generate UUID
        setProductId(UUID.randomUUID().toString());
    }

    // Required by SaleableItem interface
    @Override
    public void sellItem() {
        System.out.println("Selling widget: " + widgetName + " for $" + price);
        // Add your selling logic here
    }

    @Override
    public String toString() {
        return "Widget{" +
                "widgetName='" + widgetName + '\'' +
                ", price=" + price +
                ", productId='" + getProductId() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Widget widget = (Widget) o;
        return Double.compare(price, widget.price) == 0 &&
                Objects.equals(widgetName, widget.widgetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widgetName, price);
    }
}