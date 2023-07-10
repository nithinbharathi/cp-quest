import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		while(a != 0 || b != 0 || c != 0){
			
			if(b-a == c-b){
				System.out.println("AP "+ (c+c-b));
			}else{
				System.out.println("GP "+(c*(c/b)));
			}
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
	}
	}
}
