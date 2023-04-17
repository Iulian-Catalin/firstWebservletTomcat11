package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDB {

    public void insert(String foodName) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // conectare la db cu incarcare driver
        final String URLDB = "jdbc:postgresql://192.168.50.128:5432/postgres";
        final String USERNAMEDB = "postgres";
        final String PWDDB = "postgres";
        int val = 0; // 1
        try {
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // rulare sql
            PreparedStatement pSt = conn.prepareStatement("insert into fn (foodname) values (?)");
            pSt.setString(1, foodName);

            val = pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listAllFood() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // conectare la db cu incarcare driver
        final String URLDB = "jdbc:postgresql://192.168.50.128:5432/postgres";
        final String USERNAMEDB = "postgres";
        final String PWDDB = "postgres";
        List<String> l = new ArrayList<>();
        int val = 0; // 1
        try {
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // rulare sql
            PreparedStatement pSt = conn.prepareStatement("select * from fn");

            ResultSet rs = pSt.executeQuery();


            while (rs.next()) {
                l.add(rs.getString("foodname"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
}
