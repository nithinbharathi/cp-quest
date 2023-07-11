import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int test = input.nextInt();
	    while(test-->0){
	        int n = input.nextInt();
	        int flag = 0;
	        int temp = n;
	        while(true){
	            temp = n;
    	        while(temp>=3){
    	            int rem = temp%3;
    	            if(rem >1){
    	                flag = 1;
    	                break;
    	            }
    	            temp/=3;
    	        }
    	        if(temp == 1)break;
    	        n++;
	        }
	        System.out.println(n);
	    }
	}
}
