import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;

/**
 * This class includes the unit testing test cases
 * for all the main functions in the class
 * TextBuddy.
 * The actual output are compared to the expected
 * output to ensure the correct implementations
 * 
 * @author Ouyang Danwen
 *
 */
public class TextBuddyTest {
    
	//for testing standard-out display
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	public void testAdd() throws IOException {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();

		//execute the command
		TextBuddy.executeUserCommand("add", "add hello boys");

		//test message correctness
		assertEquals("Added to test.txt: \"hello boys\"\r\n", outContent.toString());

		//test file content
		assertEquals("1. hello boys", TextBuddy.readLine());

		cleanUpStreams();
		TextBuddy.clearUpForTesting();
	}


	private void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	private void cleanUpStreams() {
		System.setOut(null);
	}

	/**
	 * This method add some random entries to the file
	 */
	private void addRandomEntriesToFile() {
		TextBuddy.addToFileTesting("sort out someThings to consider");
		TextBuddy.addToFileTesting("just for some fun");
		TextBuddy.addToFileTesting("Not really");
	}


}