class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size == 0 || size == 1 || size == 2){
            return nums.length;
        }
        int prev_seen = nums[0];
        int count =1;
        int index=1;
        for(int i =1 ;i<size;i++){
            if(nums[i] == prev_seen){
                count++;
            }else{
                count =1;
            }
            if(count<3){
                nums[index++] = nums[i];
            }
            prev_seen = nums[i];
        }
        return index;
    }
}
