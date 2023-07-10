import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
 Scanner input = new Scanner(System.in);
	    
	    while(true){
	        int n = input.nextInt();
	        if(n == 0)break;
	        int arr[] = new int[n];
	        for(int i =0;i<n;i++){
	            arr[i] = input.nextInt();
	            arr[i]--;
	        }
	        HashMap<Integer,Integer>map = new HashMap<>();
	        for(int i =0;i<n;i++){
	            map.put(arr[i],i);
	        }
	        int temp[] =  new int[n];
	        for(int i =0;i<n;i++){
	            temp[i] = map.get(i);
	        }
	        int z =0;
	        int count =0;
	        while(z<n){
	            if(temp[z] == arr[z]){
	                count++;
	            }
	            z++;
	        }
	        if(count == n){
	            System.out.println("ambiguous");
	        }else{
	            System.out.println("not ambiguous");
	        }
	        
	    }
	    
	}
}
