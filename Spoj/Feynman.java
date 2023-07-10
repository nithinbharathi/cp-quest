import java.util.*;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
	Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			int n = input.nextInt();
			int result =0;
			if(n==0){
				break;
			}else{
				result = (n*(n+1)*(2*n+1))/6;
				System.out.println(result);
			}
		
	}
	
		
	}
	
} 
