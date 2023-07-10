class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        helper(result,0,subset,nums);
        return result;
    }
    public static void helper(List<List<Integer>> result,int curr,ArrayList<Integer>subset,int nums[]){
        if(curr == nums.length){
            result.add(new ArrayList<>(subset));   
            return;
        }
        subset.add(nums[curr]);
        helper(result,curr+1,subset,nums);
        subset.remove(subset.size()-1);
        helper(result,curr+1,subset,nums);
    }
}
