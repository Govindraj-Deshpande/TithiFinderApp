package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class TithiDBManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tithi_finder";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Updated method signature: removed tithiDate parameter
    public static void insertTithiData(String name, String dob, String tithi, String day) {
        System.out.println("Attempting DB insert:");
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Tithi: " + tithi);
        System.out.println("Day: " + day);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO tithidata (name, dob, tithi, day) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Convert dob from dd-MM-yyyy to yyyy-MM-dd for MySQL date format
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDob = inputFormat.parse(dob);
            String formattedDob = sqlFormat.format(parsedDob);

            stmt.setString(1, name);
            stmt.setString(2, formattedDob);
            stmt.setString(3, tithi);
            stmt.setString(4, day);

            stmt.executeUpdate();
            System.out.println("✔ Data inserted successfully with day: " + day);
        } catch (Exception e) {
            System.out.println("❌ SQLException while inserting:");
            e.printStackTrace();
        }
    }
}
