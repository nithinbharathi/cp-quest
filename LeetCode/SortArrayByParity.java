class Solution {
    public int[] sortArrayByParity(int[] A) {
        int size = A.length;
        if(A == null || size == 0 || size == 1){
            return A;
        }
        int left =0;
        int right = size-1;
        int temp;
        while(left<= right){
            if(A[right]%2 == 0){
                temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                left++;
            }else{
                right--;
            }
        }
        
        return A;
    }
}
