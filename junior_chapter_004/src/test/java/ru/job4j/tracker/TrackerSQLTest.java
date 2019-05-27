package ru.job4j.tracker;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    String nameTable = "itemUser";
    @Test
    public void checkConnection() {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertThat(sql.init(), is(true));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkAddTableItemTracker() {
        try (TrackerSQL sql = new TrackerSQL()) {
            String id = new Timestamp(System.currentTimeMillis()).toString();
            sql.init();
            sql.add(new Item(id, "Vasya", "add"));
            ResultSet rs = sql.executeQuerySQL(String.format("%s %s %s%s%s%s", "SELECT * FROM", nameTable, "WHERE id_item =", "\'", id, "\'"));
            System.out.println(rs.isBeforeFirst());
            while (rs.next()) {
                assertThat(rs.getString("id_item"), is(id));
            }
            rs.close();
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkReplaceTableItemTracker() {
        try (TrackerSQL sql = new TrackerSQL()) {
            String id = new Timestamp(System.currentTimeMillis()).toString();
            sql.init();
            sql.add(new Item(id, "Vasya", "add"));
            sql.replace(id, new Item(id, "Ivan", "replace"));
            ResultSet rs = sql.executeQuerySQL(String.format("%s %s %s%s%s%s", "SELECT * FROM", nameTable, "WHERE id_item =", "\'", id, "\'"));

            while (rs.next()) {
                assertThat(rs.getString("nameUser"), is("Ivan"));
            }
            rs.close();
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkDeleteTableItemTracker() {
        try (TrackerSQL sql = new TrackerSQL()) {
            String id = new Timestamp(System.currentTimeMillis()).toString();
            sql.init();
            sql.add(new Item(id, "Vasya", "need to delete"));
            sql.delete(id);
            ResultSet rs = sql.executeQuerySQL(String.format("%s %s %s%s%s%s", "SELECT * FROM", nameTable, "WHERE id_item =", "\'", id, "\'"));
            assertThat(rs.next(), is(false));
            rs.close();
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenFindAllItemAndDeleteAllItemForTable() {
        try (TrackerSQL sql = new TrackerSQL()) {
            sql.init();
            List<Item> items = sql.findAll();
            for(Item item : items) {
                sql.delete(item.getId());
            }
            ResultSet rs = sql.executeQuerySQL(String.format("%s %s", "SELECT * FROM", nameTable));
            assertThat(rs.next(), is(false));
            rs.close();
        } catch (Exception e ) {
        throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenFindByNameForItems() {
        try (TrackerSQL sql = new TrackerSQL()) {
            sql.init();
            sql.add(new Item("id", "Vasya", "add for find Name"));
            List<Item> items = sql.findByName("Vasya");
            for(Item item : items) {
                System.out.println(item.getName());
                sql.delete(item.getId());
                assertThat(item.getName(), is("Vasya"));
            }
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenFindByIDForItems() {
        try (TrackerSQL sql = new TrackerSQL()) {
            sql.init();
            String id = new Timestamp(System.currentTimeMillis()).toString();
            sql.add(new Item(id, "Vasya", "add for find ID"));
            Item item = sql.findById(id);
                assertThat(item.getId(), is(id));
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenGetPositionTable() throws SQLException {
        try (TrackerSQL sql = new TrackerSQL()) {
            sql.init();
            int count = 10;
            int oldcount = sql.getPosition();
            for (int id = 0; id < count; id++) {
                sql.add(new Item(Integer.toString(id), String.format("%s %s", "Name", id)));
            }
            assertThat(sql.getPosition(), is(count + oldcount));
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenDeleteAllRows() {
        try (TrackerSQL sql = new TrackerSQL()) {
            sql.init();
            sql.deleteAllRows();
            ResultSet rs = sql.executeQuerySQL(String.format("%s %s%s","SELECT EXISTS(SELECT * FROM", nameTable, ")"));
            assertThat(rs.isBeforeFirst(), is(true));
            rs.close();
        } catch (Exception e ) {
            throw new IllegalStateException(e);
        }
    }
}