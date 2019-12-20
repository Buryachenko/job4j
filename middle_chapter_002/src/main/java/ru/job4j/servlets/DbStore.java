package ru.job4j.servlets;
import com.google.common.base.Joiner;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private static final Logger LOG = LogManager.getLogger(DbStore.class.getName());

    public DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/postgres");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("jhq(I3edG");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        createTable();
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean update(User user) {
        String sql = String.format("%s %s %s %s %s %s %s %s%s%s",
                "UPDATE",
                "UsersDbStore",
                "SET id_user    = ?,",
                "name           = ?,",
                "login          = ?,",
                "email          = ?,",
                "createDate     = ?",
                "WHERE  id_user = \'", user.getId(), "\'");
        executeSQL(sql, user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format("%s %s %s%s%s",
                "DELETE FROM",
                "UsersDbStore",
                "WHERE  id_user = \'", user.getId(), "\'");
        executeSQL(sql);
        return true;
    }

    @Override
    public Optional<User> findById(int id) {
        String sql = String.format("%s %s %s%s%s",
                "SELECT * FROM", "UsersDbStore", "WHERE id_user = \'", id, "\'");
        User user = new User();
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(Integer.valueOf(rs.getString("id_user")));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setCreateDate(rs.getString("createDate"));
            }
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return Optional.of(user);
    }

    @Override
    public boolean add(User user) {
        String sql = String.format("%s %s %s %s",
                "INSERT INTO",
                "UsersDbStore",
                "(id_user, name, login, email, createDate)",
                "VALUES (?, ?, ?, ?, ?)");
        executeSQL(sql, user);
        return true;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(String.format("%s %s", "SELECT * FROM", "UsersDbStore"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(Integer.valueOf(rs.getString("id_user")));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setCreateDate(rs.getString("createDate"));
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return users;
    }

    private void createTable() {
        executeSQL(Joiner.on(" ").join(
                "CREATE TABLE IF NOT EXISTS",
                "UsersDbStore",
                "(id serial primary key,",
                "id_user varchar(1000),",
                "name varchar(1000),",
                "login varchar(1000),",
                "email varchar(1000),",
                "createDate varchar(1000))"
        ));
    }

    private void executeSQL(String sql) {
        try (Connection connection = SOURCE.getConnection()){
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.execute();
             ps.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void executeSQL(String sql, User user) {
        try (Connection connection = SOURCE.getConnection()){
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, String.valueOf(user.getId()));
                ps.setString(2, user.getName());
                ps.setString(3, user.getLogin());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getCreateDate());
                ps.execute();
                ps.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
