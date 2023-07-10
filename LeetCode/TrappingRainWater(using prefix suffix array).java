//Better Approach over the brute Force
//Time  Complexity: o(n)
//Space Complexity: o(n)


/*
So the bottleneck from the brute force approach is that we had to find the max_left_bar & max_right_bar for each
bar that we encounter so if we could figure out a way to store these lengths by precomputing them earlier then the time 
complexity can easily be brought down so for this reason we can use prefix and suffix arrays to precompute the maximum 
right and left bar for each bar in the given height[] array and use them when needed
*/

class Solution {
    public int trap(int[] height) {
        if(height.length<=2)return 0;
       int left[] = new int[height.length];           // stores the left maximum bar for each bar
       int right[]  = new int[height.length];         // stores the right maximum bar for each bar
        left[0] = height[0];
        int count =0;
        right[right.length-1] = height[height.length-1];
        
        for(int i = 1;i<height.length;i++){
            left[i]  = Math.max(left[i-1],height[i]);
        }
        
        for(int i = height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        
        for(int i=0;i<height.length;i++){            // scan over to compute the total volume that each bar can accumulate
                                                    // using the same formula as used in the brute force approach
            count += Math.min(left[i],right[i])-height[i];
        }
            
        return count;
    }
}
