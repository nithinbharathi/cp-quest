import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	 Scanner input = new Scanner(System.in);
	    
	    while(input.hasNextBigInteger()){
	           BigInteger n = input.nextBigInteger();
	        if(n.equals(BigInteger.ZERO)){
	            System.out.println("0");
	        }else if(n.equals(BigInteger.ONE)){
	            System.out.println("1");
	        }else{
	     
	        BigInteger t = new BigInteger("2");
	        BigInteger ans = t.multiply(n);
	        System.out.println(ans.subtract(t));
	        }
	    }
	}
}
