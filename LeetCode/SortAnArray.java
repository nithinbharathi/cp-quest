class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)return nums; //edge cases if any 
        mergeSort(nums,nums.length);
        return nums;
        
    }
    public static void mergeSort(int nums[],int n){
        if(n<2){                          //if there is only one element we can reduce any further so return
            return;
        }
        int mid = n/2;
        int left[] = new int[mid];
        int right[] = new int[n-mid];
        for(int i=0;i<mid;i++){           //contructing the left subarray;
            left[i] = nums[i];
        }
        for(int i =mid;i<n;i++){
            right[i-mid]  = nums[i];      //constructing the right subarray;
        }
        
        mergeSort(left,mid);                  //recursive call with leftSubArray
        mergeSort(right,n-mid);               //recursive call with righSubArray
        merge(mid,n-mid,left,right,nums);     //Merging both of them after hitting the base case
        
        
        
    }
    
    //Merge function
    public static void merge(int leftSize,int rightSize,int left[],int right[],int result[]){
        int i =0,j=0,z=0;
        while(i<leftSize && j<rightSize){
            if(left[i]<=right[j]){
                result[z++] = left[i++];
            }else{
                result[z++] = right[j++];
            }
        }
        while(i<leftSize){
            result[z++] = left[i++];
        }
        while(j<rightSize){
            result[z++] =right[j++];
        }
    }
}
