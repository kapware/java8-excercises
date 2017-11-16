package mapdecoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyMapDecoder implements MapDecoder
{
	@Override
	public Map<String, String> decode(String s) {
		if (s == null) {
			return null;
		}

		Map<String, String> result = new HashMap<>();

		if ("".equals(s)) {
			return result;
		}

		if (!s.contains("&")) {
			throw new IllegalArgumentException("Input string does not contain an `&`");
		}

		Arrays.stream(s.split("&"))
				.map(pair -> {
					if (!pair.contains("=")) {
						throw new IllegalArgumentException("Pair does not contain `=`");
					}
					return pair.split("=");
				})
				.forEach(pair -> result.put(pair[0], pair.length == 1 ? "" : pair[1]));

		return result;
	}
}

