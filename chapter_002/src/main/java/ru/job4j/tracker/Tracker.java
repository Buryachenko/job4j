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

	public int getPosition() {
		return position;
	}
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
		item.setId(id);
		for (int i = 0; i < position; i++) {
			if (id.equals(items[i].getId())) {
				items[i] = item;
				break;
			}
		}
	}
	public void delete(String id) {
		for (int i = 0; i < position; i++) {
			if (id.equals(items[i].getId())) {
				System.arraycopy(items, i + 1, items, i, position);
				items[position - 1] = null;
				this.position--;
				break;
			}
		}
	}
	public Item[] findAll() {
		return Arrays.copyOf(items, position);
	}
	public Item[] findByName(String key) {
		int pos = 0;
		Item[] result = new Item[items.length];
		for (int i = 0; i < position; i++) {
			if (key.equals(items[i].getName())) {
				result[pos++] = items[i];
			}
		}
		return Arrays.copyOf(result, pos);
	}
	public Item findById(String id) {
		Item result = null;
		for (int i = 0; i < position; i++) {
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
}