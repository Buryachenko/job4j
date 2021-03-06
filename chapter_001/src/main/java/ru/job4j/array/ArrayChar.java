package ru.job4j.array;
/**
 * Обертка над строкой.
 *  @author Buryachenko
 *  @since 08.01.2019
 *  @version 1
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
			if (value[i] != this.data[i]) {
				result = false;
				break;
			}
		}
        return result;
    }
}
