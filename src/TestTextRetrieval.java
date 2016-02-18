import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the retrieveTextFromCommand method
 * in TextBuddy class.
 * 
 * @author Ouyang Danwen
 *
 */

public class TestTextRetrieval {

	@Test
	public void test() {
		String actual1 = TextBuddy.retrieveTextFromCommand("add some things to get done");
		String expected1 = "some things to get done";
		assertEquals(actual1, expected1);
		
		String actual2 = TextBuddy.retrieveTextFromCommand("delete 1");
		String expected2 = "1";
		assertEquals(actual2, expected2);
		
		String actual3 = TextBuddy.retrieveTextFromCommand("search keyword");
		String expected3 = "keyword";
		assertEquals(actual3, expected3);
	}
	

}
