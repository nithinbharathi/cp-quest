import java.util.*;
import java.lang.*;
import java.math.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
			long n =  input.nextLong();
			String c = Long.toString(n-1);
			BigInteger first = new BigInteger("192");
			BigInteger sum = new BigInteger("0");
			if(n == 1){
				System.out.println("192");
			}else{
				sum = first.add(new BigInteger(c).multiply(new BigInteger("250")));
				System.out.println(sum);
			}
			
		}
		input.close();
		
	}
}
