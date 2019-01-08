package ru.job4j.loop;
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
public class BoardTest {
	@Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X%S X %SX X%S", line, line, line);
        assertThat(result, is(expected));
	}
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {		
		Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
		/*System.out.println(String.format("X X X%S X X %SX X X%S X X %S", line, line, line, line));*/
        String expected = String.format("X X X%S X X %SX X X%S X X %S", line, line, line, line);
        assertThat(result, is(expected));
	}
}
