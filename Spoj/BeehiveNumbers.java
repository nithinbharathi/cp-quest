import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
Scanner input = new Scanner(System.in);
	
		while(true){
		    int n = input.nextInt();
		    if(n == -1)break;
		    int s =1;
		    int i =0;
		    while(true){
		        s= s+6*i;
		        if(s>n){
		            System.out.println("N");
		            break;
		        }
		        if(s == n){
		            System.out.println("Y");
		            break;
		        }
		        i++;
		    }
		}
	}
}
