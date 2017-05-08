package peddi.test.java8.nested;
import peddi.test.java8.util.BaseUnitTest;
import peddi.java8.nested.StaticNestedClassDemo;
import org.junit.Test;

public class StaticNestedClassDemoTest extends  BaseUnitTest{
	StaticNestedClassDemo instance = new StaticNestedClassDemo();	
	
	@Test
	public void test(){
		instance.demo();
	}
	
}
