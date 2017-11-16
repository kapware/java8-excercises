package findarray2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyFindArray implements FindArray {
	public int findArray(int[] array, int[] subArray) {
		if (array == null || subArray == null || subArray.length == 0) {
			return -1;
		}
		String subArrayString = Arrays.stream(subArray)
				.parallel()
				.boxed()
				.map(Object::toString)
				.collect(Collectors.joining(","));

		String arrayString = Arrays.stream(array)
				.parallel()
				.boxed()
				.map(Object::toString)
				.collect(Collectors.joining(","));

		int index = arrayString
				.lastIndexOf(subArrayString);

		if (index <= 0) {
			return index;
		}

		return (int) arrayString.substring(0, index).chars()
				.parallel()
				.mapToObj(i -> String.valueOf((char)i))
				.filter(str -> ",".equals(str))
				.count();
	}
}