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
			
			BigInteger sum = new BigInteger("0");
			for(int i =0;i<n;i++){
				BigInteger a = input.nextBigInteger();
				sum = sum.add(a);
			}
			String c = Long.toString(n);
			if((sum.mod(new BigInteger(c))).equals(BigInteger.ZERO)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		input.close();
	}
}
