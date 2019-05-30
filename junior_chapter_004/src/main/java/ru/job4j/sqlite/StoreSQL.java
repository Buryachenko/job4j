package ru.job4j.sqlite;
import com.google.common.base.Joiner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * Class StoreSQL
 * @athor Buryachenko
 * @since 31.05.19
 * @version 1
 */

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private final String nameTable = "entry";
    private final String structTable = "(field integer)";
    private static final Logger Log = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
        this.config.init();
        createNewDatabase();
    }

    public void executeSQL(String sql) {
        try {
            if (!this.connect.isClosed()) {
                PreparedStatement ps = this.connect.prepareStatement(sql);
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public ResultSet executeQuerySQL(String sql) {
        try {
            if (!this.connect.isClosed()) {
                PreparedStatement ps = this.connect.prepareStatement(sql);
                return ps.executeQuery();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return null;
    }

    public void executeSQL(String sql, Integer field) {
        try {
            if (!this.connect.isClosed()) {
                PreparedStatement ps = this.connect.prepareStatement(sql);
                ps.setInt(1, field);
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public void deleteAllRows() {
        String sql = String.format("%s %s", "DELETE FROM", nameTable);
        executeSQL(sql);
    }

    public void generate(int size) {
        deleteAllRows();
        String sql = String.format("%s %s%s %s", "INSERT INTO", nameTable, "(field)", "VALUES(?)");
        for (int i = 0; i < size; i++) {
            executeSQL(sql, i);
        }
    }

    public List<Entry> load() {
        List<Entry> entry = new ArrayList<>();
        String sql = String.format("%s %s", "SELECT * FROM", nameTable);
        try(ResultSet rs = executeQuerySQL(sql)) {
            while (rs.next()) {
                entry.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return entry;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    private void createTable() throws SQLException {
        if(! this.connect.isClosed()) {
            PreparedStatement ps = this.connect.prepareStatement(
                    Joiner.on(" ").join(
                            "CREATE TABLE IF NOT EXISTS", nameTable, structTable
                    )
            );
            ps.execute();
        }
    }

    public void createNewDatabase() {
        try {
            System.out.println(this.config.get("url"));
            this.connect = DriverManager.getConnection(config.get("url"));
            if (this.connect != null) {
                DatabaseMetaData meta = this.connect.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
            createTable();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }
}
