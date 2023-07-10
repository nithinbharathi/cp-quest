// sort and use the two pointer method just like threesome problem on leetcode
//Time Complexity: O(NlogN) for sorting O(N*N) for traversal => O(N*N) as it dominates nlogn

class Solution {
    public int triangleNumber(int[] arr) {
        int count =0;
        Arrays.sort(arr);
        for(int i =arr.length-1;i>=0;i--){
            int l = 0;
            int r = i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i]){
                    count +=r-l;
                    r--;
                }else{
                    l++;
                }
            }
        }
         return count;
        }
}
