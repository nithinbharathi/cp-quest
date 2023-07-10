class Solution {
    public void rotate(int[] nums, int k) {
        int result[] = new int[nums.length];
        
        int index = nums.length-k;
        if(k>nums.length){
            index = nums.length-(k%nums.length);
        }
        int z=0;
        for(int i = index;i<nums.length;i++){
            result[z] = nums[i];
            z++;
        }
        for(int i=0;i<index;i++){
            result[z] = nums[i];
            z++;
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }
}
