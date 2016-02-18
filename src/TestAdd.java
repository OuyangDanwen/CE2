import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestAdd {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		TextBuddy.executeUserCommand("add","add some");
		TextBuddy.executeUserCommand("add","add more");
		TextBuddy.executeUserCommand("add","add something");
		
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("some");
		expected.add("more");
		expected.add("something");
		
		assertEquals(TextBuddy.backupListForEasyDeletion,expected);
		
	}

}
