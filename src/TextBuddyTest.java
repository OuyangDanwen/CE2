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
	
	/**
	 * This method tests valid display 
	 * from a non-empty file
	 */
	@Test
	public void testDisplay1() {
		TextBuddy.initializeForTesting("test.txt");
		addRandomEntriesToFile();
		setUpStreams();

		//execute the command
		TextBuddy.executeUserCommand("display", "display");

		//test the message displayed to user
		assertEquals("1. sort out someThings to consider\r\n" 
				+ "2. just for some fun\r\n" +
				"3. Not really\r\n", outContent.toString());

		//clean up
		cleanUpStreams();
		TextBuddy.clearUpForTesting();

	}

	/**
	 * This method tests invalid display
	 * from an empty file
	 */
	@Test
	public void testDisplay2() {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();

		//execute the command
		TextBuddy.executeUserCommand("display", "display");

		//test the message displayed to user
		assertEquals("test.txt is empty\r\n", outContent.toString());

		//clean up
		cleanUpStreams();
		TextBuddy.clearUpForTesting();
	}
    
	@Test
	public void testSort() throws IOException {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();
		addRandomEntriesToFile();

		//execute the command
		TextBuddy.executeUserCommand("sort", "sort");

		//test message correctness
		assertEquals("test.txt sorted alphabetically\r\n", 
				outContent.toString());

		//test whether the entries are sorted correctly
		assertEquals("1. just for some fun", TextBuddy.readLine());

		//supposed to delete "Not really"
		//so "just for fun" will be printed again
		TextBuddy.executeUserCommand("delete", "delete 2");
		assertEquals("1. just for some fun", TextBuddy.readLine());

		//supposed to delete "just for fun"
		//so "sort out someThings to consider" will be printed
		TextBuddy.executeUserCommand("delete", "delete 1");
		assertEquals("1. sort out someThings to consider", 
				TextBuddy.readLine());

		//clean up
		cleanUpStreams();
		TextBuddy.clearUpForTesting();
	}
	
	@Test
	public void testSearch() {
		TextBuddy.initializeForTesting("test.txt");
		setUpStreams();
		addRandomEntriesToFile();

		//execute the command
		TextBuddy.executeUserCommand("search", "search some");

		//test the correctness of the printed result
		assertEquals("Exact matches from test.txt:\r\n" +
				"just for some fun\r\n\r\n" +
				"Partial matches from test.txt:\r\n" + 
				"sort out someThings to consider\r\n", outContent.toString());

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
