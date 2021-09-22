

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class unitTest {
	Lab2 counter = new Lab2();
	@DisplayName("UnitTest")
	@ParameterizedTest(name = "{index} {0} {1}")
	@MethodSource("parameterDataProvider")
	void testcase(String path,int level,String res) throws FileNotFoundException {
		assertEquals(res, counter.keyCounter(path,level));
	}

	private static Stream<Arguments> parameterDataProvider() {
		return Stream.of(
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test1.txt",1, 
						"total num: 35\n" ),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test1.txt",2, 
						"total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2 \n" ),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test1.txt",3, 
						"total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2 \n" + 
						"if-else num: 2\n"),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test1.txt",4, 
						"total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2 \n" + 
						"if-else num: 2\n" + 
						"if-elseif-else num: 2\n"),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test2.txt",1, 
						"total num: 28\n" ),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test2.txt",2, 
						"total num: 28\n" + 
						"switch num: 1\n" + 
						"case num: 3 \n"  ),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test2.txt",3, 
						"total num: 28\n" + 
						"switch num: 1\n" + 
						"case num: 3 \n" + 
						"if-else num: 5\n"),
				Arguments.of("C:\\Users\\86151\\eclipse-workspace\\Da3Shang\\src\\test2.txt",4, 
						"total num: 28\n" + 
						"switch num: 1\n" + 
						"case num: 3 \n" + 
						"if-else num: 5\n" + 
						"if-elseif-else num: 1\n")
				);
	}
}