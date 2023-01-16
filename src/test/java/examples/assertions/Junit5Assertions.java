package examples.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class Junit5Assertions {
	// boolean assertions
	@Test
	public void testAssertTrue() {
		assertTrue(true); // will pass
		assertTrue(false); // will fail; throws AssertionFailedError error
	}

	@Test
	public void testAssertFalse() {
		assertFalse(false);
		assertFalse(true); // will fail; throws AssertionFailedError error
	}

	// null assertions
	@Test
	public void testAssertNull() {
		assertNull(null);
		assertNull("test");
	}

	@Test
	public void testAssertNonNull() {
		assertNotNull("test");
		assertNotNull(null);
	}

	// object equals
	@Test
	public void testAssertEquals() {
		String actual = "1";
		String expected = "1";

		assertEquals(expected, actual);
	}

	@Test
	public void testAssertNotEquals() {
		String actual = "1";
		String expected = "2";

		assertNotEquals(expected, actual);
	}

	@Test
	public void testAssertSame() {
		String expected = new String("1");
		String actual = expected;

		assertSame(expected, actual);
	}

	@Test
	public void testAssertArrayEquals() {
		String[] expected = new String[] { "This",  "is", "a", "test", "array"};
		String[] actual = "This is a test array".split(" ");

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testAssert2DArrayEquals() {
		String[][] expected = new String[][] {
				{ "This", "is", "row", "one" },
				{ "This", "is", "row", "two" },
				{ "This", "is", "row", "three" }
		};
		String[][] actual = new String[3][];
		actual[0] =  "This is row one".split(" ");
		actual[1] =  "This is row two".split(" ");
		actual[2] =  "This is row three".split(" ");

		assertArrayEquals(expected, actual);
	}

	@Test
	void testAssertIterableEquals() {
		ArrayList<String> expected = new ArrayList<>();
		expected.add("This");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		expected.add("list");

		LinkedList<String> actual = new LinkedList<>();
		actual.add("This");
		actual.add("is");
		actual.add("a");
		actual.add("test");
		actual.add("list5");

		assertIterableEquals(expected, actual);
	}

	@Test
	void testAssertIterableEqualsIfContentsDiffer() {
		ArrayList<String> expected = new ArrayList<>();
		expected.add("test");
		expected.add("string");


		LinkedList<String> actual = new LinkedList<>();
		actual.add("test");
		actual.add("big string");

		assertIterableEquals(expected, actual);
	}

	@Test
	void testAssertThrows() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			int[] arr = new int[1];
			arr[0] = 0;

			// will throw IndexOutOfBoundsException
			int value = arr[1];
		});
	}

	@Test
	void testAssertThrowsWithExceptionValidation() {
		IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			int[] arr = new int[1];
			arr[0] = 0;

			// will throw IndexOutOfBoundsException
			int value = arr[1];
		});

		// verifying the error message
		assertEquals("Index 1 out of bounds for length 1", exception.getMessage());
	}

	@Test
	void testAssertDoesNotThrowException() {
		assertDoesNotThrow(() -> {
			int[] arr = new int[1];
			arr[0] = 0;
			// does not throw ay exception
		});
	}

	@Test
	void testAssertDoesNotThrowExceptionWithOutputValidation() {
		String actual = assertDoesNotThrow(() -> {
			String[] arr = new String[1];
			arr[0] = "This is a test string";
			return arr[0];
		});
		// asserting the return value of our method under test
		assertEquals("This is a test string", actual);
	}
}


