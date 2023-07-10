import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int s = 1;
        while(test-->0){
            String a[] = br.readLine().split(" ");
            int n = Integer.parseInt(a[0]);
            int num = Integer.parseInt(a[1]);
            String ar[] = br.readLine().split(" ");
            int arr[] = new int[num];
            
            for(int i =0;i<num;i++){
                arr[i] = Integer.parseInt(ar[i]);
            }
            Arrays.sort(arr);
            int min =0;
            int flag = 0;
            for(int i =num-1;i>=0;i--){
                n-=arr[i];
                min++;
                if(n<=0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                System.out.println("Scenario #"+ s + ":");
				System.out.println(min);
            }else{
				System.out.println("Scenario #"+ s + ":");
				System.out.println("impossible");            
            }
            System.out.println();
           s++; 
        }
    }	
}
