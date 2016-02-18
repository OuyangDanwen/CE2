import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the getComamndType method in the
 * TextBuddy class.
 * 
 * @author Ouyang Danwen
 *
 */

public class TestCommandType {

	@Test
	public void test() {
		String actual1 = TextBuddy.getCommandType("add something");
		String expected1 = "add";
		assertEquals(actual1,expected1);
		
		String actual2 = TextBuddy.getCommandType("delete 3");
		String expected2 = "delete";
		assertEquals(actual2,expected2);

		String actual3 = TextBuddy.getCommandType("sort");
		String expected3 = "sort";
		assertEquals(actual3,expected3);
		
		String actual4 = TextBuddy.getCommandType("search something");
		String expected4 = "search";
		assertEquals(actual4,expected4);

		String actual5 = TextBuddy.getCommandType("exit");
		String expected5 = "exit";
		assertEquals(actual5,expected5);
		
		String actual6 = TextBuddy.getCommandType("display");
		String expected6 = "display";
		assertEquals(actual6,expected6);
		
	}

}
