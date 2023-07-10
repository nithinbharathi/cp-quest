class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        List<Integer>  n = new ArrayList<>();
        n.add(1);
        result.add(n);
        for(int i = 1; i<numRows;i++){
            List<Integer> prev_list = result.get(i-1);
            ArrayList<Integer> templist = new ArrayList<>();
            templist.add(1);
            for(int j =1; j<i;j++ ){
                templist.add(prev_list.get(j-1) + prev_list.get(j));
            }
            templist.add(1);
            result.add(templist);
        }
        return result;
    }
}
