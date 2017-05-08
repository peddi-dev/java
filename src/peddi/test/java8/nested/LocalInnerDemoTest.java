/**
 * 
 */
package peddi.test.java8.nested;

import static org.junit.Assert.*;

import org.junit.Test;

import peddi.test.java8.util.BaseUnitTest;
import peddi.java8.nested.LocalInnerDemo;

/**
 * @author PKRISTIP
 *
 */
public class LocalInnerDemoTest extends BaseUnitTest {
	LocalInnerDemo instance = new LocalInnerDemo();
	
	@Test
	public void test() {
	//	fail("Not yet implemented");
		int result = instance.calculate();
		System.out.println("multplication:" + result);
	}

}
