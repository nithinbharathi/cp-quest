int maxSubArray(int* nums, int numsSize) {
    int max_sum = 0;
    int i,sum=0;
    max_sum = sum = nums[0];
   for(i=1;i<numsSize;i++){
       sum = max(nums[i],sum+nums[i]);
       if(sum>max_sum){
           max_sum = sum;
       }
   }
    return max_sum;
}
int max(int a,int b){
    if(a>b){
        return a;
    }
    return b;
}