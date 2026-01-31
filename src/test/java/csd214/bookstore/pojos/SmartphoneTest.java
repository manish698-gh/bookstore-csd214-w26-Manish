package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {


    @Test
    void testEquality() {
        Smartphone s1 = new Smartphone("Apple", 999.99, 12, 48);
        Smartphone s2 = new Smartphone("Apple", 999.99, 12, 48);
        Smartphone s3 = new Smartphone("Samsung", 999.99, 12, 48);

        assertEquals(s1, s2, "Same smartphones should be equal");
        assertNotEquals(s1, s3, "Different brand should not be equal");
    }


    @Test
    void testConstructor() {
        Smartphone phone = new Smartphone("Google", 699.99, 24, 64);

        assertEquals("Google", phone.getBrand());
        assertEquals(64, phone.getCameraMP());
        assertEquals(699.99, phone.getPrice(), 0.001);
        assertEquals(24, phone.getWarrantyMonths());
    }


    @Test
    void testSellItem() {
        Smartphone phone = new Smartphone("OnePlus", 499.99, 12, 48);
        phone.setCopies(10);

        phone.sellItem();

        assertEquals(9, phone.getCopies(), "Stock should decrease after selling");
    }
}