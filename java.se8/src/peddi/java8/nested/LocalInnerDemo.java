package peddi.java8.nested;

public class LocalInnerDemo {
	
	private int l = 10;
	
	public int calculate(){
		final int w = 5;
		class LocalInner{
			public int multiply(){
				return l*w;
			}
		}
		
		LocalInner linner = new LocalInner();
	 return	linner.multiply();
	}
}


