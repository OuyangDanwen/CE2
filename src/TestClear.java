import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestClear {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		TextBuddy.executeUserCommand("clear", "clear");
		
		//an empty list
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected,TextBuddy.backupListForEasyDeletion);
	}

}
