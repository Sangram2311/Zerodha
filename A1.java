package string;

public class A1 {
	
	public static void main(String[] args) {
		
		String s1 = "xyz";
		String s2 = "xyz";
		
		
		System.out.println(s1==s2);
		
		//System.out.println(s1.equals(s2));
		
		
		
		
		String s3 = new String("hello");
		String s4 = new String("hello");
	//	System.out.println(s1.equals(s3));
		System.out.println(s3==s4);
	}

}
