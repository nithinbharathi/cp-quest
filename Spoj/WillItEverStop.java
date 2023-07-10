import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
			if(n%2== 0){
				while(n>0 && n%2 == 0){
					n = n/2;
				}
			}
			if(n == 1){
				System.out.println("TAK");
			}else{
				System.out.println("NIE");
			}
			
	}
}
