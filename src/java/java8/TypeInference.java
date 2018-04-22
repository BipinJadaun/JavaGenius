package java.java8;

interface StringLength{
	public int getLength(String s);
}



public class TypeInference {
	
	public void getLengthUsingLambda(StringLength sl) {
		int len = sl.getLength("Hello World!");
		System.out.println(len);
		
	}
	public static void main(String[] args) {
		
		TypeInference type = new TypeInference();
		
		//instead of creating interface instance through lambda expression and passing it method as parameter
		//we can directly pass the lambda expression 
		//it know that parameter type of getLength() method is String, so no need to specify the argument type
		
		type.getLengthUsingLambda((s) -> s.length());

	}

}
