package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LaptopTest {

    @Test
    void testEquality() {
        Laptop l1 = new Laptop("Dell", 999.99, 12, 15.6);
        Laptop l2 = new Laptop("Dell", 999.99, 12, 15.6);

        l1.setBrand("Dell"); l1.setPrice(999.99); l1.setWarrantyMonths(12);
        l2.setBrand("Dell"); l2.setPrice(999.99); l2.setWarrantyMonths(12);

        assertEquals(l1, l2);
        assertEquals(l1.hashCode(), l2.hashCode());
    }

    @Test
    void testConstructor() {
        Laptop laptop = new Laptop("MacBook", 1299.99, 24, 13.3);
        laptop.setBrand("MacBook"); laptop.setPrice(1299.99); laptop.setWarrantyMonths(24);

        assertEquals("MacBook", laptop.getBrand());
        assertEquals(24, laptop.getWarrantyMonths());
        assertEquals(13.3, laptop.getScreenSize());
    }

    @Test
    void testSellItem() {
        Laptop laptop = new Laptop("Lenovo", 899.99, 12, 14.0);
        laptop.setCopies(10);

        laptop.sellItem();

        assertEquals(9, laptop.getCopies());
    }
}