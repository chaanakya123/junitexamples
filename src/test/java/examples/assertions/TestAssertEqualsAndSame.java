package examples.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestAssertEqualsAndSame {

	@Test
	void testAssertAll() {
		assertAll(
				() -> assertEquals("1", "1"),
				() -> assertEquals(1, 1),
				() -> assertTrue(1 == 2)
		);
	}

	@Test
	void testAssertions() {
		assertEquals(new String("1"), new String("1"));
		assertEquals("1", "1");
		assertTrue(1 == 2);
	}

	@Test
	void testAssertSame() {
		assertSame("1", "1"); // assertion will pass
		assertSame("1", new String("1")); // assertion will fail
		assertSame(new String("1"), new String("1")); // assertion will fail
	}
}
