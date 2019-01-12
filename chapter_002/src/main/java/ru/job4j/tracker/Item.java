package ru.job4j.tracker;
/**
 *  Class Класс заявок.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class Item {
	private String id;
	private String name;
	private String desc;
	private long created;
	private String[] comments;

	public Item(String name,  String description) {
		this.name = name;
		this.desc = description;
		this.created = System.currentTimeMillis();
	}

	public  Item(String name, String desc, long created) {
		this.name = name;
		this.desc = desc;
		this.created = created;
	}

	public void setId(String value) {
		id = value;
	}
	public String getId() {
		return id;
	}
	public  String getName() {
		return  name;
	}
}