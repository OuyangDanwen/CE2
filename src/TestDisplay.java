import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 * This class tests the display function
 * by comparing the standard output with
 * the expected one
 * 
 * @author Ouyang Danwen
 *
 */

public class TestDisplay {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	public void test() {
		TextBuddy.initializeForTesting();
		
		setUpStreams();
		
		TextBuddy.executeUserCommand("add", "add hello boys");
		TextBuddy.executeUserCommand("display", "display");
		
		assertEquals("Added to test.txt: \"hello boys\"\r\n1. hello boys\r\n", outContent.toString());
		
		TextBuddy.file.delete();
		cleanUpStreams();
		
	}

	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
