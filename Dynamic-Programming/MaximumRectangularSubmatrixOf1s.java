
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumRectangularSubMatrix
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	     int arr[][] =  {{1,1,1,0},
                         {1,1,1,1},
                         {0,1,1,0},
                         {0,1,1,1},
                         {1,0,0,1},
                         {1,1,1,1}};
        int temp[]  = new int[arr[0].length];
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<temp.length;j++){
                if(arr[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += arr[i][j];
                }
            }
            max = Math.max(max,largest_rectangle(temp));
        }
       System.out.println(max);
        
	}
	public static int largest_rectangle(int arr[]){
	      int max =0;
	      Stack<Integer>stack = new Stack<>();
	      int i=0;
	      for(i=0;i<arr.length;){
	          if(stack.isEmpty() || arr[stack.peek()]<=arr[i]){
	              stack.push(i);
	              i++;
	          }else{
	              int pop = stack.pop();
	              int area=0;
    	            if(stack.isEmpty()){
    	                   area = arr[pop]*i;
    	              }else{
    	                   area= arr[pop]*(i-stack.peek()-1);
    	              }
    	              if(area>max){
    	                  max= area;
    	            }
	            }
	      }
	      while(!stack.isEmpty()){
	          int pop = stack.pop();
	          int area =0;
    	            if(stack.isEmpty()){
    	                  area = arr[pop]*i;
    	              }else{
    	                  area = arr[pop]*(i-stack.peek()-1);
    	              }
    	                if(area>max){
    	                    max= area;
    	            }
	           }
	           return max;
	      }
	}
