/**
 * 
 */
package peddi.java8.nested;

/**
 * @author PKRISTIP
 *
 */
public class AnonymousInnerClassDemo {
	float price = 100;
	abstract class SalesTodayOnly{
		abstract int discount();
	}
	/**
	 * Anonymous inner class based on abstract class
	 */
	SalesTodayOnly sale1 = new SalesTodayOnly(){
		int discount(){
			return 30; 
		}
	};
	
	interface SalesThisWeek {
		int discount();
	}
	/**
	 * Anonymous inner class based on interface 
	 */
	SalesThisWeek sale2 = new SalesThisWeek() {
		public int discount(){
			return 10;
		}
	};
	
	private float calculateDiscountedPrice(int discount){
		float result = price * (100-discount)/100;
		return result;
	}
	
	public float getDiscountedPrice(SalesTodayOnly sale){
		return calculateDiscountedPrice(sale.discount());
	}
	
	public float getDiscountedPrice(SalesThisWeek sale){
		return calculateDiscountedPrice(sale.discount()); 
	}
	
	interface SalesThisMonth{
		int discount();
	}
	
	public float getDiscountedPrice( SalesThisMonth sale){
		return calculateDiscountedPrice(sale.discount());
	}
	
	public void demo(){
		float dp1 = getDiscountedPrice(sale1);
		float dp2 = getDiscountedPrice(sale2);
		
	/**
	 * Anonymous Inner Class as method parameter.
	 */
		float dp3 = getDiscountedPrice(new SalesThisMonth() {
			public int discount(){
				return 5;
			}
		  });	
		
		System.out.println("SalesTodayOnly: " + dp1);
		System.out.println("SalesThisWeek: " + dp2);
		System.out.println("SalesThisMonth: " + dp3);
	}
}
