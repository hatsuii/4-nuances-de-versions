package test.assertion;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class Assertions {

	@Test
	  public void testAssertArrayEquals() {
		// succes: les deux chaines doivent contenir les memes caractères dans le meme ordre
	    byte[] expected = "mot".getBytes();
	    byte[] actual = "mot".getBytes();
	    assertArrayEquals("failure - byte arrays not same", expected, actual);
	  }
	@Test
	  public void testAssertEquals() {
		// succes: les deux string doivent etre identiques
	    assertEquals("failure - strings are not equal", "text", "text");
	  }
	@Test
	  public void testAssertFalse() {
	    assertFalse("failure - should be false", false);
	  }
	@Test
	  public void testAssertNotNull() {
		// succes: le parametre ne dois pas être null
	    assertNotNull("should not be null", new Object());
	  }
	@Test
	  public void testAssertNotSame() {
		// succes: les deux objets sont différents
	    assertNotSame("should not be same Object", new Object(), new Object());
	  }
	@Test
	  public void testAssertNull() {
	    assertNull("should be null", null);
	  }
	@Test
	  public void testAssertSame() {
		// succes: les deux objet sont identique (les mêmes)
	    Integer aNumber = Integer.valueOf(768);
	    assertSame("should be same", aNumber, aNumber);
	  }
	@Test
	  public void testAssertThatBothContainsString() {
		// succes: tout les caractere sont présent dans le string
	    assertThat("albumen", both(containsString("a")).and(containsString("b")));
	  }
	@Test
	  public void testAssertThatHasItems() {
		// succes: les éléments sont present dans la liste
	    assertThat(Arrays.asList("one", "two", "three"), hasItems("two", "three"));
	  }
	@Test
	  public void testAssertThatEveryItemContainsString() {
		// succes: le caractere est présent dans tout les string
	    assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	  }
	@Test
	  public void testAssertThatHamcrestCsoreMatchers() {
		// succes: toute les chaine sont égale et commencent pas le string
	    assertThat("good", allOf(equalTo("good"), startsWith("good")));
	    // succes: une chaien au moins est différente du string
	    assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
	    // succes: l'une des chaine est églae au string
	    assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
	    // succes: l'entier ne  match pas avec les autre entier
	    assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(9)).or(equalTo(845))));
	    // succes: les deux objet ne sont pas vistime de la meme instance
	    assertThat(new Object(), not(sameInstance(new Object())));
	  }
	@Test
	  public void testAssertTrue() {
	    assertTrue("failure - should be true", true);
	  }


}
