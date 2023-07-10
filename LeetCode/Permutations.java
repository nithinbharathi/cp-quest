class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        helper(result,nums,0);
        return result;
    }
    public static void helper(List<List<Integer>> result, int nums[],int curr){
        if(curr == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int x:nums){
                list.add(x);
            }
            result.add(list);
            return;
        }
        for(int i=curr;i<nums.length;i++){
            swap(nums,curr,i);
            helper(result,nums,curr+1);
            swap(nums, curr,i);
            
        }
        
    }
    public static void swap(int nums[],int i,int j){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
