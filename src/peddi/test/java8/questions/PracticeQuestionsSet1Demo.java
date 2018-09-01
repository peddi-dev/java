/**
 * 
 */
package peddi.test.java8.questions;

import static org.junit.Assert.*;

import org.junit.Test;
import peddi.java8.questions.PracticeQuestionsSet1;
import peddi.test.java8.util.BaseUnitTest;
/**
 * @author PKRISTIP
 *
 */
public class PracticeQuestionsSet1Demo extends BaseUnitTest{
	PracticeQuestionsSet1 instance = new PracticeQuestionsSet1();
	@Test
	public void testEmployee() {
		
		//fail("Not yet implemented");
		PracticeQuestionsSet1.Employee obj = instance.new Employee();
		obj.demo();
	}
	
	@Test 
	public void testStringEqualsTest1() {
		PracticeQuestionsSet1.StringEqualsTest1 obj = instance.new StringEqualsTest1();
		obj.demo();
	}

}
