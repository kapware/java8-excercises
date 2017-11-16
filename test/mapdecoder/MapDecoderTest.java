package mapdecoder;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Spec:
 *  String -> Map
 *  Format: ([key]=[value]&)*
 *  Example: foo=bar&baz=fap -> {"foo": "bar", "baz": "fap"}
 *
 * Additionally:
 * - if key or value is emplty, then equal sign needs to pe preserved, for example "=bar&baz=" is valid,
 * - for empty String return empty Map,
 * - for null String return null,
 * - for invalid string, throw IllegalArgumentException
 */
public class MapDecoderTest {
	@Test
	public void simpleExampleTest() {
		// given:
		String foo = "one=1&two=2";
		// when:
		Map<String, String> result = new MyMapDecoder().decode(foo);

		// then:
		Map<String, String> expectedResult = new HashMap<>();
		expectedResult.put("one", "1");
		expectedResult.put("two", "2");
		assertEquals(expectedResult, result);
	}

	@Test
	public void emptyKeyTest() {
		// given:
		String foo = "=1&two=2";
		// when:
		Map<String, String> result = new MyMapDecoder().decode(foo);

		// then:
		Map<String, String> expectedResult = new HashMap<>();
		expectedResult.put("", "1");
		expectedResult.put("two", "2");
		assertEquals(expectedResult, result);
	}

	@Test
	public void emptyValueTest() {
		// given:
		String foo = "=1&two=";
		// when:
		Map<String, String> result = new MyMapDecoder().decode(foo);

		// then:
		Map<String, String> expectedResult = new HashMap<>();
		expectedResult.put("", "1");
		expectedResult.put("two", "");
		assertEquals(expectedResult, result);
	}

	@Test
	public void emptyInputTest() {
		// given:
		String foo = "";
		// when:
		Map<String, String> result = new MyMapDecoder().decode(foo);

		// then:
		Map<String, String> expectedResult = new HashMap<>();
		assertEquals(expectedResult, result);
	}

	@Test
	public void nullInputTest() {
		// given:
		String foo = null;
		// when:
		Map<String, String> result = new MyMapDecoder().decode(foo);

		// then:
		assertNull(result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalInputTest() {
		// given:
		String foo = "iaghei4g gerah ger fdas garbag";
		// when:
		new MyMapDecoder().decode(foo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalInputNoEqualsTest() {
		// given:
		String foo = "iaghei4g gerah &ger fdas garbag";
		// when:
		new MyMapDecoder().decode(foo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalInputMissingEqualsTest() {
		// given:
		String foo = "iaghei4g gerah &ger fdas= garbag";
		// when:
		new MyMapDecoder().decode(foo);
	}
}
