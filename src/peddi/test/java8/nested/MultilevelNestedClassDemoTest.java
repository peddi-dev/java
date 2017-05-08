/**
 * 
 */
package peddi.test.java8.nested;

import static org.junit.Assert.*;

import org.junit.Test;
import peddi.java8.nested.MultilevelNestedClassDemo;
import peddi.test.java8.util.BaseUnitTest;

/**
 * @author PKRISTIP
 *
 */
public class MultilevelNestedClassDemoTest extends BaseUnitTest{
	private MultilevelNestedClassDemo instance = new MultilevelNestedClassDemo();
	

	@Test
	public void testAccessMembersAtAllLevels() {
		MultilevelNestedClassDemo.Level2Nested level2NestedObj = instance.new Level2Nested();
		MultilevelNestedClassDemo.Level2Nested.Level3Nested level3NestedObj = level2NestedObj.new Level3Nested();
		level3NestedObj.accessMembersAtAllLevels();
	}

}
