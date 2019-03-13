package test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test1forSuite.class, Test2forSuite.class, Test3forSuite.class })
public class AllTests {
	
}
