public class HelloWorld { 

	private static int i = 0 ; 
	
	public static void main(String[] args) { 
		System.out.println("Hello World!"); 
		i++; 
		System.out.println("new value:" + i); 
		doPrinting(); 
	} 
	
	static void doPrinting() { 
		System.out.println("print something"); 
		System.out.println("print something"); 
		System.out.println("print something"); 
	} 
} 

