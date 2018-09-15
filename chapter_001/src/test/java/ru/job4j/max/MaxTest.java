package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {
	/**
	 * Test whenFirstLessSecond.
	 */
	@Test
	public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}

}