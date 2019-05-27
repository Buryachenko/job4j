package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger Log = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;
    private String nameTable = "itemUser";
    private String structTable = "(id serial primary key, id_item varchar(1000), nameUser varchar(1000), description varchar(1000), created timestamp)";

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            createTable();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    private void createTable() throws SQLException {
        if(! this.connection.isClosed()) {
            PreparedStatement ps = this.connection.prepareStatement(
                    Joiner.on(" ").join(
                    "CREATE TABLE IF NOT EXISTS", nameTable, structTable
                    )
            );
            ps.execute();
        }
    }

    private List<Item> getItems(ResultSet rs) {
        List<Item> items = new ArrayList<>();
        try {
            while (rs.next()) {
                String id = rs.getString("id_item");
                String nameUser = rs.getString("nameUser");
                String desc = rs.getString("description");
                Long created = rs.getTimestamp("created").getTime();
                items.add(new Item(id, nameUser, desc, created));
            }
            rs.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return items;
    }

    public void executeSQL(String sql) {
        try {
            if (!this.connection.isClosed()) {
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public void executeSQL(String sql, Item item) {
        try {
            if (!this.connection.isClosed()) {
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.setString(1, item.getId());
                ps.setString(2, item.getName());
                ps.setString(3, item.getDesc());
                ps.setTimestamp(4, new Timestamp(item.getCreated()));
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public ResultSet executeQuerySQL(String sql) {
        try {
            if (!this.connection.isClosed()) {
                PreparedStatement ps = this.connection.prepareStatement(sql);
                return ps.executeQuery();
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Item add(Item item) {
        String sql = String.format("%s %s %s %s",
                                "INSERT INTO",
                                nameTable,
                                "(id_item, nameUser, description, created)",
                                "VALUES (?, ?, ?, ?)");
        executeSQL(sql, item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        String sql = String.format("%s %s %s %s %s %s %s%s%s",
                                "UPDATE", nameTable,
                                "SET    id_item         = ?,",
                                        "nameUser       = ?,",
                                        "description    = ?,",
                                        "created        = ?",
                                "WHERE  id_item         = \'", id, "\'");
        executeSQL(sql, item);
        return true;
    }

    @Override
    public boolean delete(String id) {
        String sql = String.format("%s %s %s%s%s",
                                "DELETE FROM",
                                nameTable,
                                "WHERE  id_item         = \'", id, "\'");
        executeSQL(sql);
        return true;
    }

    @Override
    public List<Item> findAll() {
        String sql = String.format("%s %s", "SELECT * FROM", nameTable);
        return getItems(executeQuerySQL(sql));
    }

    @Override
    public List<Item> findByName(String key) {
        String sql = String.format("%s %s %s%s%s",
                                "SELECT * FROM", nameTable, "WHERE nameUser = \'", key, "\'");
        return getItems(executeQuerySQL(sql));
    }

    @Override
    public Item findById(String id) {
        String sql = String.format("%s %s %s%s%s",
                                "SELECT * FROM", nameTable, "WHERE id_item = \'", id, "\'");
        return getItems(executeQuerySQL(sql)).get(0);
    }

    @Override
    public int getPosition() {
        int size = 0;
        try {
            String sql = String.format("%s %s",
                                "SELECT count(id)  FROM ", nameTable);
            ResultSet rs = executeQuerySQL(sql);
            while (rs.next()){
                size = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return size;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
            System.out.println("AutoClose connection");
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public void deleteAllRows() {
        String sql = String.format("%s %s", "DELETE FROM", nameTable);
        executeSQL(sql);
    }
}
