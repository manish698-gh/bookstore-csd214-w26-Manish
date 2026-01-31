package csd214.bookstore;

import csd214.bookstore.pojos.*;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    private List<SaleableItem> items = new ArrayList<>();
    private CashTill cashTill = new CashTill();
    private Scanner input = new Scanner(System.in);

    public void run() {
        populate();
        int choice = 0;
        while (choice != 99) {
            System.out.println(" Welcome to Ghimire's Everything Store");
            System.out.println("***********************");
            System.out.println(" 1. Add Items");
            System.out.println(" 2. Edit Items");
            System.out.println(" 3. Delete Items");
            System.out.println(" 4. Sell item(s)");
            System.out.println(" 5. List items");
            System.out.println("99. Quit");
            System.out.println("***********************");
            System.out.print("Enter choice: \n");

            try {
                String line = input.nextLine();
                if (line.trim().isEmpty()) continue;
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    editItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    sellItem();
                    break;
                case 5:
                    listAny();
                    break;
                case 99:
                    // Exit
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void addItem() {
        int choice = 0;
        while (choice != 99) {
            System.out.println("\nAdd an item\n");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add DiscMag");
            System.out.println("4. Add Ticket");
            System.out.println("5. Add Pen");
            System.out.println("6. Add Notebook");
            System.out.println("7. Add Laptop");
            System.out.println("8. Add Smartphone");
            System.out.println("99. Exit");

            try {
                String line = input.nextLine();
                if (line.trim().isEmpty()) continue;
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice == 99) return;

            SaleableItem item = null;
            switch(choice) {
                case 1: item = new Book(); break;
                case 2: item = new Magazine(); break;
                case 3: item = new DiscMag(); break;
                case 4: item = new Ticket(); break;
                case 5: item = new Pen(); break;
                case 6: item = new Notebook(); break;
                case 7: item = new Laptop(); break;
                case 8: item = new Smartphone(); break;
                default: System.out.println("Invalid selection."); continue;
            }

            if(item instanceof Editable) {

                ((Editable)item).initialize(this.input);
            }
            addItem(item);
        }
    }

    public void addItem(SaleableItem item) {
        items.add(item);
    }

    public void listAny() {

    }

    public void listI(Object o) {
        System.out.println(o.toString());
    }

    public void editItem() {
        System.out.println("Select item index to edit (0 to " + (items.size() - 1) + "):");
        for(int i=0; i<items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }

        try {
            int idx = Integer.parseInt(input.nextLine().trim());
            if (idx >= 0 && idx < items.size()) {
                SaleableItem item = items.get(idx);
                if (item instanceof Editable) {
                    editItem((Editable) item);
                } else {
                    System.out.println("Item is not editable.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid selection.");
        }
    }

    public void editItem(Editable item) {

        item.edit(this.input);
    }

    public void deleteItem() {
    }

    public void sellItem() {
    }

    public boolean findItemExists(SaleableItem item) {
        return items.contains(item);
    }

    public SaleableItem findItem(SaleableItem item) {
        int index = items.indexOf(item);
        if (index != -1) return items.get(index);
        return null;
    }

    public SaleableItem getItem(SaleableItem item) {
        return findItem(item);
    }

    public void populate() {

    }


    public void clearItems() {
        items.clear();
    }

    public List<SaleableItem> getItems() {
        return new ArrayList<>(items);
    }
}