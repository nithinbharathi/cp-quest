class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x = king[0];
        int y = king[1];
        boolean visited[][] = new boolean[8][8];
        for(int i =0;i<queens.length;i++){
            int a = queens[i][0];
            int b = queens[i][1];
            visited[a][b] = true;
        }
        ArrayList<Integer>temp = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        for(int i =-1;i<=1;i++){
            for(int j =-1;j<=1;j++){
                if(i == 0 && j == 0)continue;
                do{
                    x+=i;
                    y+=j;
                }while(valid(x,y) && !visited[x][y]);
                if(valid(x,y)){
                    temp.add(x);
                    temp.add(y);
                    result.add(new ArrayList<>(temp)); 
                }
                temp.clear();
                x = king[0];
                y = king[1];
            }
        }
       return result; 
        
    }
    
    public static boolean valid(int x,int y){
        if(x>=0 && y>=0 && x<8 && y<8)return true;
        return false;
    }
}
