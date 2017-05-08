/**
 * 
 */
package peddi.test.java8.enums;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import peddi.java8.enums.Seasons;

/**
 * @author PKRISTIP
 *
 */
public class SeasonsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("**** Begin SeasonsTest *****");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("**** End SeasonsTest *****");
	}

	@Test
	public void test() {

		Seasons s = Seasons.SUMMER;
		switch (s) {
		case SUMMER:
			System.out.println("Summer season.");
			break;
		case WINTER:
			System.out.println("Winter season.");
			break;
		case SPRING:
			System.out.println("Spring season.");
			break;
		case FALL:
			System.out.println("Fall season.");
			break;
		default:
			break;
		}
		// fail("Not yet implemented");
	}

}
