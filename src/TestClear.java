import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * This class is used to test the clear function in
 * the class TextBuddy.
 * It checks both the backup list and the file contents
 * @author Ouyang Danwen
 *
 */

public class TestClear {

	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		TextBuddy.executeUserCommand("clear", "clear");
		
		//an empty list
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected,TextBuddy.backupListForEasyDeletion);
		
		try {
			File check = new File("check.txt");
			check.createNewFile();
			assertTrue("The files differ!", FileUtils.contentEquals(
					check, TextBuddy.file));
			check.delete();
			TextBuddy.file.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
