package csd214.bookstore.mysql;

import csd214.bookstore.pojos.Smartphone;
import java.sql.*;
import java.util.UUID;

public class JdbcSmartphoneApp {
    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";

    public static void main(String[] args) {
        System.out.println("=== Lab 3: Smartphone JDBC Application ===\n");


        if (args.length > 0 && args[0].equals("test")) {
            testPersistence();
        } else {
            runFullDemo();
        }
    }

    private static void runFullDemo() {
        System.out.println("=== FIRST RUN: Inserting and Testing Data ===\n");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connected to database!");

            // 1. Create Table
            createTable(conn);

            // 2. Insert smartphones
            System.out.println("\n--- INSERTING SMARTPHONES ---");
            insertSampleSmartphones(conn);

            // 3. Read all smartphones
            System.out.println("\n--- READING ALL SMARTPHONES ---");
            listAllSmartphones(conn);

            // 4. Update price
            System.out.println("\n--- UPDATING PRICE ---");
            updateSmartphonePrice(conn, 1, 1099.99);

            // 5. Show updated data
            System.out.println("\n--- UPDATED DATA ---");
            listAllSmartphones(conn);

            // 6. Final state
            System.out.println("\n--- FINAL INVENTORY ---");
            listAllSmartphones(conn);

            System.out.println("\n✓ Lab 3: All CRUD operations completed!");
            System.out.println("Data is persisted in MySQL database.");
            System.out.println("\n=== INSTRUCTIONS FOR PERSISTENCE TEST ===");
            System.out.println("1. STOP this app completely");
            System.out.println("2. Run again with argument: 'test'");
            System.out.println("3. Data should still be there!");

        } catch (SQLException e) {
            System.err.println("Database error:");
            e.printStackTrace();
        }
    }

    private static void testPersistence() {
        System.out.println("=== PERSISTENCE TEST: App Was Restarted ===\n");
        System.out.println("This run tests if data survived the app restart...\n");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Reconnected to database!");

            // Check if table exists
            if (!tableExists(conn)) {
                System.out.println("Table 'smartphones' doesn't exist yet.");
                System.out.println("Run the app without 'test' argument first.");
                return;
            }

            // Show what's already in the database
            System.out.println("\n--- DATA THAT SURVIVED RESTART ---");
            listAllSmartphones(conn);

            // Count records
            String sql = "SELECT COUNT(*) as count FROM smartphones";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    System.out.println("\nTotal smartphones in database: " + count);

                    if (count > 0) {
                        System.out.println("\n🎉 PERSISTENCE TEST PASSED!");
                        System.out.println("✓ Data survived application restart!");
                        System.out.println("✓ This proves MySQL persistence works!");
                        System.out.println("✓ Lab 3 requirement satisfied!");
                    } else {
                        System.out.println("\n❌ PERSISTENCE TEST FAILED");
                        System.out.println("Data was lost. Check your code.");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error:");
            e.printStackTrace();
        }
    }

    private static boolean tableExists(Connection conn) throws SQLException {
        String sql = "SHOW TABLES LIKE 'smartphones'";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS smartphones (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "product_id VARCHAR(36), " +
                "brand VARCHAR(255) NOT NULL, " +
                "warranty_months INT NOT NULL, " +
                "camera_mp INT NOT NULL, " +
                "price DOUBLE NOT NULL, " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'smartphones' created successfully.");
        }
    }

    private static void insertSampleSmartphones(Connection conn) throws SQLException {
        // Phone 1: Apple iPhone
        Smartphone phone1 = new Smartphone();
        phone1.setBrand("Apple");
        phone1.setWarrantyMonths(24);
        phone1.setCameraMP(48);
        phone1.setPrice(999.99);
        phone1.setProductId(UUID.randomUUID().toString());
        insertSmartphone(conn, phone1);

        // Phone 2: Samsung Galaxy
        Smartphone phone2 = new Smartphone();
        phone2.setBrand("Samsung");
        phone2.setWarrantyMonths(18);
        phone2.setCameraMP(108);
        phone2.setPrice(899.99);
        phone2.setProductId(UUID.randomUUID().toString());
        insertSmartphone(conn, phone2);

        // Phone 3: Google Pixel
        Smartphone phone3 = new Smartphone();
        phone3.setBrand("Google");
        phone3.setWarrantyMonths(12);
        phone3.setCameraMP(50);
        phone3.setPrice(699.99);
        phone3.setProductId(UUID.randomUUID().toString());
        insertSmartphone(conn, phone3);
    }

    private static void insertSmartphone(Connection conn, Smartphone phone) throws SQLException {
        // SECURITY
        String sql = "INSERT INTO smartphones (product_id, brand, warranty_months, camera_mp, price) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phone.getProductId());
            ps.setString(2, phone.getBrand());
            ps.setInt(3, phone.getWarrantyMonths());
            ps.setInt(4, phone.getCameraMP());
            ps.setDouble(5, phone.getPrice());
            ps.executeUpdate();
            System.out.println("Inserted: " + phone.getBrand() + " Smartphone");
        }
    }

    private static void listAllSmartphones(Connection conn) throws SQLException {
        String sql = "SELECT * FROM smartphones ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.printf("ID: %d | Brand: %-10s | Warranty: %2d months | Camera: %3dMP | Price: $%7.2f%n",
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getInt("warranty_months"),
                        rs.getInt("camera_mp"),
                        rs.getDouble("price"));
            }

            if (!hasData) {
                System.out.println("No smartphones found in database.");
            }
        }
    }

    private static void updateSmartphonePrice(Connection conn, int id, double newPrice) throws SQLException {
        // SECURITY: Using PreparedStatement with ? placeholders
        String sql = "UPDATE smartphones SET price = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated price for " + rows + " smartphone(s).");
        }
    }

    private static void deleteSmartphone(Connection conn, int id) throws SQLException {
        // SECURITY
        String sql = "DELETE FROM smartphones WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " smartphone(s).");
        }
    }
}