package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *  Class Класс обертка для Item.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class Tracker {

	private List<Item> items = new ArrayList();

	public int getPosition() {
		return items.size();
	}

	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		return item;
	}
	public boolean replace(String id, Item item) {
		boolean result = false;
		item.setId(id);
		for (Item itemOld : items) {
			if (id.equals(itemOld.getId())) {
				result = itemOld.equals(items.set(items.indexOf(itemOld), item));
				break;
			}
		}
		return result;
	}
	public boolean delete(String id) {
		boolean result = false;
		for (Item itemOld : items) {
			if (id.equals(itemOld.getId())) {
				result = items.remove(itemOld);
				break;
			}
		}
		return result;
	}
	public List<Item> findAll() {
		return items;
	}
	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item itemOld : items) {
		    if (key.equals(itemOld.getName())) {
		        result.add(itemOld);
            }
        }
		return result;
	}
	public Item findById(String id) {
		Item result = null;
        for (Item itemOld : items) {
            if (id.equals(itemOld.getId())) {
				result = itemOld;
				break;
			}
		}
		return result;
	}
	private String generateId() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Error Sleep");
		}
		return "11111" + Long.toString(System.currentTimeMillis());
	}
}