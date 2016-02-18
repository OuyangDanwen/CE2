import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * This class is used to test the delete function in
 * the class TextBuddy.
 * It checks both the backup list and the file contents.
 * 
 * @author Ouyang Danwen
 *
 */

public class TestDelete {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		generateAList();

		ArrayList<String> expected = new ArrayList<String>();
		expected = getExpectedList(expected);

		TextBuddy.executeUserCommand("delete", "delete 1");
		expected.remove(0);
		
		File check = new File("check.txt");
		try {
			writeToFile(check, expected);
			assertEquals(expected,TextBuddy.
					backupListForEasyDeletion);
			assertTrue("The files differ!", 
					FileUtils.contentEquals(check, TextBuddy.file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		check.delete();
		TextBuddy.file.delete();

	}

	public void generateAList() {
		TextBuddy.backupListForEasyDeletion.add("some");
		TextBuddy.backupListForEasyDeletion.add(
				"some more things");
		TextBuddy.backupListForEasyDeletion.add(
				"so many more things to do");
		TextBuddy.backupListForEasyDeletion.add("haha");
	}

	public ArrayList<String> getExpectedList(
			ArrayList<String> expected) {
		expected.add("some");
		expected.add("some more things");
		expected.add("so many more things to do");
		expected.add("haha");
		return expected;		
	}
	
	public static void writeToFile(File file, 
			ArrayList<String> expected) throws IOException {
		BufferedWriter bufferedFileWriter = new BufferedWriter(
				new FileWriter(file,true));
		for (int i = 0; i < expected.size(); i++) {
			String text = expected.get(i);
			bufferedFileWriter.write((i + 1) + ". " + text);
			bufferedFileWriter.newLine();
			bufferedFileWriter.flush();
		}
		bufferedFileWriter.close();
	}

}
