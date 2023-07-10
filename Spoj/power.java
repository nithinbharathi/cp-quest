
import java.util.*;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		    int a = input.nextInt();
		    long b = input.nextLong();
		    long result = power(a,b);
		    System.out.println(result);
		}
	}
	public static long power(int base,long power){
	    long res = 1;
	    while(power>0){
	        if(power%2 == 1)res = (res*base)%10;
	        power/=2;
	        base = (base*base)%10;
	    }
	    return res;
	}
	
} 
