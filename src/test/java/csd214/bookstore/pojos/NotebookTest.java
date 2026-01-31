package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {

    @Test
    void testEquality() {
        Notebook n1 = new Notebook("Moleskine", 100, 12.99);
        Notebook n2 = new Notebook("Moleskine", 100, 12.99);
        Notebook n3 = new Notebook("Moleskine", 200, 12.99);

        n1.setBrand("Moleskine"); n1.setPrice(12.99);
        n2.setBrand("Moleskine"); n2.setPrice(12.99);
        n3.setBrand("Moleskine"); n3.setPrice(12.99);

        assertEquals(n1, n2);
        assertEquals(n1.hashCode(), n2.hashCode());
        assertNotEquals(n1, n3);
    }

    @Test
    void testConstructor() {
        Notebook notebook = new Notebook("Leuchtturm", 120, 15.99);
        notebook.setBrand("Leuchtturm"); notebook.setPrice(15.99);

        assertEquals("Leuchtturm", notebook.getBrand());
        assertEquals(120, notebook.getPageCount());
        assertEquals(15.99, notebook.getPrice());
    }
}