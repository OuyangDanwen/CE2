import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * This class is used to test the add function in
 * the class TextBuddy.
 * It checks both the backup list and the file contents.
 * 
 * @author Ouyang Danwen
 *
 */

public class TestAdd {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		generateAList();
		
		
		ArrayList<String> expected = new ArrayList<String>();
		expected = getExpectedList(expected);
		
		assertEquals(TextBuddy.backupListForEasyDeletion,expected);
		
		try {
			File check = new File("check.txt");
			writeToFile(check, expected);
			assertTrue("The files differ!", 
					FileUtils.contentEquals(check, TextBuddy.file));
			check.delete();
			TextBuddy.file.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void generateAList() {
		TextBuddy.executeUserCommand("add","add some");
		TextBuddy.executeUserCommand("add","add more");
		TextBuddy.executeUserCommand("add","add something");
	}
	
	public static ArrayList<String> getExpectedList(
			ArrayList<String> expected) {
		expected.add("some");
		expected.add("more");
		expected.add("something");
		
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
