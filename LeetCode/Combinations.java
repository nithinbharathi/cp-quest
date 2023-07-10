class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>result = new ArrayList<>();
        if(k==0 || n==0){
            return result;
        }
        ArrayList<Integer> templist = new ArrayList<>();
        helper(result,templist,n,k,1);
        return result;
    }
    public static void helper( List<List<Integer>>result, ArrayList<Integer> templist,int n, int k,int index){
        if(templist.size() == k){
            result.add(new ArrayList<>(templist));
            return;
        }
         
        for(int i = index;i<=n;i++){
        if(templist.size()>=1 && templist.get(templist.size()-1) == i) continue;
           templist.add(i);
            helper(result,templist,n,k,i+1);
            templist.remove(templist.size()-1);
            
        }
    }
}
