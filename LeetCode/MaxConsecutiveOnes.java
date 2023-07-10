class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp=0;
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]== 1){
                temp++;
                if(count<temp){
                    count = temp;
                }
            }else{
                temp = 0;
            }
        }
        return  count;
    }
}
