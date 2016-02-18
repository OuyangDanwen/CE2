import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSearch {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		TextBuddy.backupListForEasyDeletion = generateAList(TextBuddy.backupListForEasyDeletion);
		ArrayList<String> actual = TextBuddy.search("search some");
		
		ArrayList<String> expected = new ArrayList<String>();
		expected = getCorrectSearchResult(expected);	
		assertEquals(expected,actual);
		
	}
	
	public static ArrayList<String> generateAList(ArrayList<String> list) {
		list.add("some");
		list.add("someMore");
		list.add("same but how");
		list.add("some more things to add");
		
		return list;
	}
	
	public static ArrayList<String> getCorrectSearchResult(ArrayList<String> expected) {
		expected.add("some");
		expected.add("some more things to add");
		expected.add("someMore");
		
		return expected;	
	}

}
