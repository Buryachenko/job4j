package ru.job4j.tracker;
/**
 *  Class Класс заявок.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class Item {
	private String id = "";
	private String name;
	private String desc;
	private long created;

	public Item(String name,  String desc) {
		this.name = name;
		this.desc = desc;
		this.created = System.currentTimeMillis();
	}

	public Item(String name,  String desc, long created) {
		this.name = name;
		this.desc = desc;
		this.created = created;
	}

	public Item(String id, String name,  String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.created = System.currentTimeMillis();
	}
	public  Item(String id, String name, String desc, long created) {
		this.id = id;
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
	public  String getDesc() {
		return  desc;
	}
	public long getCreated() {
		return this.created;
	}
}