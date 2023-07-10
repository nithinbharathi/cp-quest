import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
		int x = input.nextInt();
		int y = input.nextInt();
		if( x != y && x-y != 2){
			System.out.println("No Number");
		}else if(x>=y && x%2 ==0 && y% 2== 0){
			System.out.println(x+y);
		}else {
			System.out.println(x+y-1);
			}
		}
	}
}
