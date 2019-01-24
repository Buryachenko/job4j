package ru.job4j.tracker;
/**
*	Class Базовый класс для совершения пользователем действий с заявками.
*	@author Buryachenko
*	@since 24.01.19
*	@version 1
*/
public abstract class BaseAction implements UserAction {
	private final int key;
	private final String name;
	
	protected BaseAction(final int key, final String name) {
		this.key = key;
		this.name = name;
	}
	
	@Override
	public int key() {
		return this.key;
	}
	
	@Override
	public String info() {
		return this.name;
	}
}