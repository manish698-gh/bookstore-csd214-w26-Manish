package csd214.bookstore;

import csd214.bookstore.pojos.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAppFlow_AddPen() {
        // 1. Build the Script
        StringBuilder script = new StringBuilder();
        script.append("1\n");        // Main Menu: Add Items
        script.append("5\n");        // Add Menu: Add Pen (Assuming 5 is Pen)
        script.append("Bic\n");      // Brand
        script.append("2.49\n");     // Price
        script.append("10\n");       // Copies
        script.append("Blue\n");     // Color
        script.append("99\n");       // Exit Add Menu
        script.append("99\n");       // Quit App

        // 2. Inject
        System.setIn(new ByteArrayInputStream(script.toString().getBytes()));

        // 3. Run
        App app = new App() {
            @Override
            public void populate() { /* empty to ensure clean state */ }
        };

        // Capture output to prevent console spam
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        app.run();

        // Restore System.out
        System.setOut(originalOut);

        // 4. Verify
        Pen expected = new Pen("Bic", "Blue", 2.49);
        expected.setCopies(10);
        SaleableItem result = app.findItem(expected);

        assertNotNull(result, "The App should contain the Blue Bic Pen we added via console");
    }
}