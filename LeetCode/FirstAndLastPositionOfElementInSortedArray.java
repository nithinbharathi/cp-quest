class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 )return new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        int pos = -1;
        int arr[] = new int[2];
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] ==target){
                pos = mid;
                right = mid-1;
                
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(pos == -1){
           arr[0] = -1;
           arr[1] = -1;
            return arr;
        }else{
            arr[0] = pos;
        }
        left = 0;
        right =nums.length-1; 
         while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] ==target){
                pos = mid;
                left = mid+1;
                
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        arr[1]  =pos;
        return arr;
        
        
    }
}
