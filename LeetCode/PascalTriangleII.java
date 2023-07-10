class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer>t = new ArrayList<>();
        t.add(1);
        result.add(t);
        for(int i=1;i<rowIndex+1;i++){
            List<Integer> prev = result.get(i-1);
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result.get(rowIndex);
    }
}
