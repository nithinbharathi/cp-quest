class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int i=0;
        int left =0;
        int right =0;
      while(i<A.length-1 && A[i]<A[i+1]){
           i++;
           left++;
        }
        while(i<A.length-1 && A[i] >A[i+1]){
            i++;
            right++;
        }
      if(left == 0 || right ==0){
          return false;
      }
       return i+1 == A.length;
    }
}
