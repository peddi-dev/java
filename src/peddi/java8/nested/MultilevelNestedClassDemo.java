package peddi.java8.nested;

public class MultilevelNestedClassDemo {
	private int x = 10;
	
	public class Level2Nested{
		
		private int x = 20;
		
		public class Level3Nested{
			private int x = 30;
			
			public void accessMembersAtAllLevels(){
				System.out.println("===Level3Nested.accessMembersAtAllLevels()===");
				System.out.println("x = " + x);
				System.out.println("this.x = " + this.x);
				System.out.println("Level3Nested.this.x = " + Level3Nested.this.x);
				System.out.println("Level2Nested.this.x = " + Level2Nested.this.x);
				System.out.println("MultilevelNestedClass.this.x = " + MultilevelNestedClassDemo.this.x);
			}
		}
	}

}
