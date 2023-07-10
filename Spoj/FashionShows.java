import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		while(test-->0){
			int n = input.nextInt();
			int men[] = new int[n];
			int women[] = new int[n];
			for(int i =0;i<n;i++){
				men[i] = input.nextInt();
			}
			for(int i =0;i<n;i++){
				women[i] = input.nextInt();
			}
			Arrays.sort(men);
			Arrays.sort(women);
			int sum =0;
			for(int i =0;i<n;i++){
				sum+=men[i]*women[i];
			}
			System.out.println(sum);
		}
		input.close();
	}
}
