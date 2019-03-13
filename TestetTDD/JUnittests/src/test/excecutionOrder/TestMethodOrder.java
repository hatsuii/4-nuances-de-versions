package test.excecutionOrder;

import org.junit.Test;

public class TestMethodOrder {

	@Test
    public void testb() {
        System.out.println("first");
    }
    @Test
    public void testsdtg() {
        System.out.println("second");
    }
    @Test
    public void testert() {
        System.out.println("third");
    }

}
