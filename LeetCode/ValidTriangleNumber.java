class Solution {
    public int triangleNumber(int[] arr) {
        int count =0;
        for(int i =0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                        if(arr[j]+arr[k]>arr[i]
                          && arr[j]+arr[i]>arr[k]
                          && arr[k]+arr[i]>arr[j]){
                            count++;
                        }
                    }
                }
            }
         return count;
        }
}
