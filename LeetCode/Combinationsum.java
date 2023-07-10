class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0){
            return result;
        }
        ArrayList<Integer>templist = new ArrayList<>();
        helper(result,templist,target,candidates,0);
        return result;
    }
    public static void helper(List<List<Integer>> result, ArrayList<Integer>templist,int target,int candidates[],int curr){
        if(target<0)return;
        if(target == 0){
            result.add(new ArrayList<>(templist));
        }
        for(int i=curr;i<candidates.length;i++){
            templist.add(candidates[i]);
            helper(result,templist,target-candidates[i],candidates,i);
            templist.remove(templist.size()-1);
        }
    }
    
}
