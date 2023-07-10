class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        char placement[][] = new char[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(placement[i],'.');
        }
        helper(result,col,placement,0,n);
        return result;
    }
    public static void helper(List<List<String>> result,ArrayList<Integer> col,char arr[][],int row,int n){
        if(row == n){
            ArrayList<String> list= new ArrayList<>();
            for(int i =0;i<n;i++){
               list.add(String.valueOf(arr[i])); 
            }
            result.add(list);
            return;
            
        }
        for(int i=0;i<n;i++){
            col.add(i);
            if(is_valid(col)){
                arr[row][i] = 'Q';
                helper(result,col,arr,row+1,n);
            }
            col.remove(col.size()-1);
            arr[row][i] = '.';
        }
    }
    public static boolean is_valid(ArrayList<Integer>col){
        int row_id = col.size()-1;
        for(int i=0;i<row_id;i++){
            int diff = Math.abs(col.get(i) - col.get(row_id));
            if(diff == 0 || diff == row_id - i  ){
                return false;
            }
        }
        return true;
    }
}
