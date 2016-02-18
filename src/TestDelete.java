import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestDelete {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		generateAList();

		ArrayList<String> expected = new ArrayList<String>();
		expected = getExpectedList(expected);

		TextBuddy.executeUserCommand("delete", "delete 1");
		expected.remove(0);
		assertEquals(expected,TextBuddy.backupListForEasyDeletion);

		TextBuddy.executeUserCommand("delete", "delete 3");
		expected.remove(2);
		assertEquals(expected,TextBuddy.backupListForEasyDeletion);



	}

	public void generateAList() {
		TextBuddy.backupListForEasyDeletion.add("some");
		TextBuddy.backupListForEasyDeletion.add("some more things");
		TextBuddy.backupListForEasyDeletion.add("so many more things to do");
		TextBuddy.backupListForEasyDeletion.add("haha");
	}

	public ArrayList<String> getExpectedList(ArrayList<String> expected) {
		expected.add("some");
		expected.add("some more things");
		expected.add("so many more things to do");
		expected.add("haha");
		return expected;		
	}

}
