package test.timeout;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeoutTest {

	@Test(timeout=1000)
	public void testWithTimeout() {
	  assertTrue(true);
	}

}
