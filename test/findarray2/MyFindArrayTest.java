package findarray2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Spec:
 *  - locate a subarray (second param) in array (first param)
 *  - return last occurrence of sub-array (if there are more)
 *  - if not found return -1
 *  For example:
 *    [3,5,7,5,9] and [7,5] should return 2.
 */
public class MyFindArrayTest {

	@Test
	public void simpleExamplesTest1() {
		// given:
		final int[] array = new int[] {4, 9, 3, 7, 8};
		final int[] subArray = new int[] {3, 7};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(2, result);
	}

	@Test
	public void simpleExamplesTest2() {
		// given:
		final int[] array = new int[] {1,3,5};
		final int[] subArray = new int[] {1};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(0, result);
	}

	@Test
	public void simpleExamplesTest3() {
		// given:
		final int[] array = new int[] {7,8,9};
		final int[] subArray = new int[] {8,9,10};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(-1, result);
	}

	@Test
	public void simpleExamplesTest4() {
		// given:
		final int[] array = new int[] {4,9,3,7,8,3,7,1};
		final int[] subArray = new int[] {3,7};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(5, result);
	}

	@Test
	public void simpleExamplesTest5() {
		// given:
		final int[] array = new int[] {401,91,32,72,85,32,72,1231};
		final int[] subArray = new int[] {32,72};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(5, result);
	}

	@Test
	public void simpleExamplesDelimNeeded() {
		// given:
		final int[] array = new int[] {-4,37,3,7,-8,3,7,1};
		final int[] subArray = new int[] {3,7};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(5, result);
	}

	@Test
	public void simpleExamplesNullCheck() {
		// given:
		final int[] array = null;
		final int[] subArray = null;

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(-1, result);
	}

	@Test
	public void emptyCheck() {
		// given:
		final int[] array = {};
		final int[] subArray = {1, 2};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(-1, result);
	}

	@Test
	public void emptyCheck2() {
		// given:
		final int[] array = {3, 4};
		final int[] subArray = {};

		// when:
		int result = new MyFindArray().findArray(array, subArray);

		// then:
		assertEquals(-1, result);
	}
}
