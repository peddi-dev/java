/**
 * 
 */
package peddi.test.java8.nested;

import org.junit.Test;

import peddi.test.java8.util.BaseUnitTest;
import peddi.java8.nested.InnerDemo;

/**
 * @author PKRISTIP
 *
 */
public class InnerDemoTest extends BaseUnitTest {
	private InnerDemo obj = new InnerDemo();

	@Test
	public void testOuterClassPrivateMembersAccess() {
		obj.callInner();
	}
	
	@Test
	public void testInnerCreation(){
		System.out.println("Create Inner Object");
		InnerDemo.Inner inner = obj.new Inner();
		inner.go();
	}

}
