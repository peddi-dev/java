package peddi.java8.nested;

public class PrivateInterfaceDemo {
	
	private interface PrivateInterface1 {
		 void sampleMethod();
	}
	
	class PrivateInterfaceImplementor  implements PrivateInterface1 {
		public void sampleMethod(){
			System.out.println("sampleMethod in private interface");
		}		
	}
	
	public void demo(){
		PrivateInterface1 inner = new PrivateInterfaceImplementor();
		inner.sampleMethod();
	}
}


