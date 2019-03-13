package test.ignoring;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoringTest {

	@Ignore("Test is ignored as a demonstration")
	@Test
	public void testSame() {
	    assertTrue(true);
	}

}
