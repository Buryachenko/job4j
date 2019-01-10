package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Date;
/**
 *  Class Класс обертка для Item.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class Tracker {
	private final Item[] items = new Item[100];
	private int position = 0;

	public Item add(Item item) {
		item.setId(this.generateId());
		if (this.position < items.length) {
			this.items[this.position++] = item;
		} else {
			item = null;
		}
		return item;
	}
	public void replace(String id, Item item) {
		for (int i = 0; i < items.length; i++) {
			if (id.equals(items[i].getId())) {
				items[i] = item;
				break;
			}
		}
	}
	public void delete(String id) {
		for (int i = 0; i < items.length; i++) {
			if (id.equals(items[i].getId())) {
				cutItem(i);
				this.position--;
				break;
			}
		}
	}
	public Item[] findAll() {
		int lenght = items.length;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				lenght = i + 1;
				break;
			}
		}
		return Arrays.copyOf(items, lenght);
	}
	public Item[] findByName(String key) {
		int pos = 0;
		Item[] result = new Item[items.length];
		for (int i = 0; i < items.length; i++) {
			if (key.equals(items[i].getName())) {
				result[pos++] = items[i];
			}
		}
		return Arrays.copyOf(result, pos);
	}
	public Item findById(String id) {
		Item result = null;
		for (int i = 0; i < items.length; i++) {
			if (id.equals(items[i].getId())) {
				result = items[i];
				break;
			}
		}
		return result;
	}
	private String generateId() {
		Date date = new Date(2019, 1, 1);
		return "11111" + Long.toString(date.getTime());

	}
	private void cutItem(int indexItem) {
		for (int i = indexItem; i < items.length; i++) {
			if (i < items.length - 2) {
				items[i] = items[i + 1];
			} else {
				items[i] = null;
			}
		}
	}
}