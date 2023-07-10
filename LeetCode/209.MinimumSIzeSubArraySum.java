class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int last_index = 0;
        int i=0;
        int min_length = Integer.MAX_VALUE;
        while(i<nums.length){
            sum = sum+nums[i++];
            while(sum >= s){
                 min_length = Math.min(min_length,i - last_index);
                  sum = sum - nums[last_index++]; 
            }  
        
        }
        return min_length == Integer.MAX_VALUE? 0:min_length;
        
    }    
}
