import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the getNumberOfParameters
 * method in TextBuddy class.
 * 
 * @author Ouyang Danwen
 *
 */
public class TestNumberOfParameters {

	@Test
	public void test() {
		int actual1 = TextBuddy.getNumberOfParameters("add something");
		int expected1 = 2;
		assertEquals(actual1, expected1);
		
		int actual2 = TextBuddy.getNumberOfParameters(
				"add some more things to add");
		int expected2 = 6;
		assertEquals(actual2, expected2);
		
		int actual3 = TextBuddy.getNumberOfParameters("sort");
		int expected3 = 1;
		assertEquals(actual3, expected3);
	}

}
