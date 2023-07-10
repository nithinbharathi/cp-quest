class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0 || candidates == null){
            return result;
        }
        List<Integer> templist =  new ArrayList<>();
        Arrays.sort(candidates);
        helper(result,templist,0,target,candidates);
        return result;
    }
    public void helper(List<List<Integer>> result,List<Integer>templist,int index,int target,int arr[]){
        if(target == 0){
            result.add(new ArrayList<>(templist));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index; i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1])continue;
            templist.add(arr[i]);
            helper(result,templist,i+1,target-arr[i],arr);
            templist.remove(templist.size()-1);
        }
    }
}
