class Solution {
    public int firstMissingPositive(int[] nums) {
       int z = nums.length;
        for(int i=0;i<z;i++){
            if(nums[i]>z || nums[i]<=0){
                nums[i] =z+1;
            }
        }
        for(int i=0;i<z;i++){
            int n = Math.abs(nums[i]);
            if(n>z) continue;
            if(nums[n-1]>0){
                nums[n-1] = -1*nums[n-1];
            }
        }
        for(int i =0;i<z;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return z+1;
        
  }
}
