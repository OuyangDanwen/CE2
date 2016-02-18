import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSort {
	

	@Test
	public void test() {
		TextBuddy.runTest();
		TextBuddy.backupListForEasyDeletion.add("pair");
		TextBuddy.backupListForEasyDeletion.add("cat");
		TextBuddy.backupListForEasyDeletion.add("POP");
		TextBuddy.sort();
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cat");
		expected.add("pair");
		expected.add("POP");
		
		assertEquals(expected,TextBuddy.backupListForEasyDeletion);
		
	}

}
