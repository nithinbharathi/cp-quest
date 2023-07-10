import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner input = new Scanner(System.in);
	    int test = input.nextInt();
	    if(test%10 == 0){
	        System.out.println("2");
	    }else{
	        System.out.println("1");
	        System.out.println(test%10);
	        
	    }
	}
}
