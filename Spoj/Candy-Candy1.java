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
			int arr[] = new int[n];
			int sum =0;
			for(int i =0;i<n;i++){
				arr[i] = input.nextInt();
				sum+=arr[i];
			}
			int result =0;
			if(sum%n != 0){
				System.out.println("-1");
			}else{
				int target = sum/n;
				for(int i =0;i<n;i++){
					if(arr[i] < target){
						result +=target - arr[i];
					}
				}
					System.out.println(result);
			}
		}
		input.close();
	}
}
