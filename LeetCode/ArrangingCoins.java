class Solution {
    public int arrangeCoins(int n) {
        if(n == 0){
            return 0;
        }
        int i =1;
        while(true){
            n = n-i;
            if(n<=i)break;
            i++;
        }
        return i;
    }
}
