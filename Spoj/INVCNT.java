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
					int arr[] = new int[n];
					for(int i =0;i<n;i++){
						arr[i] = input.nextInt();
					}
					int temp[] = new int[n];
					
					System.out.println(merge_sort(arr,temp,0,arr.length-1));	
					
				}
				input.close();
				
		}
   public static long merge_sort(int arr[],int temp[],int l,int h){
	   long count =0;
				if(l<h){
				int mid = (l+h)/2;
				count = merge_sort(arr,temp,l,mid);
				count += merge_sort(arr,temp,mid+1,h);
				count+=merge(arr,temp,l,mid,h);
				}
				return count;
		}
	public static long merge(int arr[],int result[],int left,int mid,int right){
		int ptr =left;
		int ptr1 = left;
		int ptr2 = mid+1;
		long count =0;
			while(ptr1<=mid && ptr2<=right){
				if(arr[ptr1]<=arr[ptr2]){
					result[ptr++] = arr[ptr1++];
				}else{
					result[ptr++] = arr[ptr2++];
					
					count = count+mid-ptr1+1;
				}
			}
			while(ptr1<=mid){
				
				result[ptr++] =arr[ptr1++];
			}
			while(ptr2<=right){
				result[ptr++] = arr[ptr2++];
			}
			for(int i =left;i<ptr;i++){
				arr[i] = result[i];
			}
			return count;
			
			
	  }
} 
