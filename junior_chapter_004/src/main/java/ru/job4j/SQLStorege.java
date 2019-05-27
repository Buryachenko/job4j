package ru.job4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SQLStorege {
    private static final Logger Log = LogManager.getLogger(SQLStorege.class.getName());

    public static void main (String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "jhq(I3edG]";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = null;
            try {
                rs = st.executeQuery("SELECT * FROM a");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            while (rs.next()) {
                System.out.println(rs.getString("a"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {

        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
    }
}
