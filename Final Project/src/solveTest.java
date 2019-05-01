import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class solveTest {

	@Test
	void test() {
		Controller tester = new Controller();
		assertEquals(24, tester.solve("10+5+7+2"), "10+5+7+2 equals 24");
		assertEquals(24, tester.solve("(6*3)+(12/2)"), "(6*3)+(12/2) equals 24");
	}

}
