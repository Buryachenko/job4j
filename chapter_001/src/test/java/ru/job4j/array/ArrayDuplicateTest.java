package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
/**
 * Test.
 *
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate arrayDuplicate = new  ArrayDuplicate();
		String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Супер", "Мир", "Мир", "Привет", "Привет", "Сыр", "Арбуз"});
		String[] equal = new String[]{"Привет", "Мир", "Супер", "Сыр", "Арбуз"};
		assertThat(result, arrayContainingInAnyOrder(equal));
	}
	@Test
	public void whenRemoveDuplicatesRandomThenArrayWithoutDuplicate() {
		ArrayDuplicate arrayDuplicate = new  ArrayDuplicate();
		int count = 10;
		String[] data = new String[count];
		for (int i = 0; i < count; i++) {
			data[i] = Integer.toString((int) (10 * Math.random()));
			System.out.println(String.format("№%S   data = %S", i, data[i]));
		}
		String[] result = arrayDuplicate.remove(data);
		System.out.println(String.format("--------------------------------------------------------------------------"));
		for (int i = 0; i < result.length; i++) {
			System.out.println(String.format("№%S   result = %S", i, result[i]));
		}
	}
}