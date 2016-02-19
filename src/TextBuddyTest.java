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
	
	/**
	 * This method tests valid deletion
	 */
	@Test
	public void testDelete1() throws IOException {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();

		//execute the command
		TextBuddy.addToFileTesting("hello boys");
		TextBuddy.executeUserCommand("delete", "delete 1");

		//test message correctness
		assertEquals("Deleted from test.txt: \"hello boys\"\r\n",
				outContent.toString());

		//test file content
		assertEquals(null, TextBuddy.readLine());

		//setUpStreams();
		//TextBuddy.executeUserCommand("delete", "delete 1");
		//assertEquals("Cannot delete from empty file, please try again\r\n", outContent.toString());


		//clean up
		cleanUpStreams();
		TextBuddy.clearUpForTesting();
	}

	/** 
	 * This method tests invalid deletion from
	 * an empty file
	 */
	@Test
	public void testDelete2() throws IOException {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();

		//execute the command
		TextBuddy.executeUserCommand("delete", "delete 1");

		//test message correctness
		assertEquals("Cannot delete from empty file, please try again\r\n",
				outContent.toString());

		//test file content
		assertEquals(null, TextBuddy.readLine());

		//clean up
		cleanUpStreams();
		TextBuddy.clearUpForTesting();
	}

	@Test
	public void testClear() throws IOException {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();

		TextBuddy.addToFileTesting("add hello boys");
		//to make sure the text is really written to file
		assertEquals("1. add hello boys", TextBuddy.readLine());

		//execute the command
		TextBuddy.executeUserCommand("clear", "clear");

		//test message correctness
		assertEquals("All content deleted from test.txt\r\n", 
				outContent.toString());

		//test file content
		assertEquals(null, TextBuddy.readLine());

		//clean up
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
