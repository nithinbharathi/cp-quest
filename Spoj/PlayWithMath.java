import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner input = new Scanner(System.in);
		   int test = input.nextInt();
		   while(test-->0){
		       long n = input.nextInt();
		       long m = input.nextInt();
		       long ans = (n*m)/gcd(n,m);
		       System.out.println(ans/n+" "+ans/m);
		   }
	}
	public static long gcd(long a,long b){
	    return (b == 0)?  a:gcd(b,a%b);
	}
}
