class Solution {
    public int findPeakElement(int[] nums) {
        int peak = 0;
        int i =0;
     for(i=1;i<nums.length;i++){
         if(nums[peak] < nums[i]){
             peak = i;
         }else{
             return peak;
         }
     }
   return peak;
    }
}
