
//Time complexity: O(n);
//Space Complexity: O(1);

/*the product of the three largest numbers in the array gives the maximum product.
So we can simply sort the array and return the product of last three numbers in the sorted array.This would work in the case
of positive integers but we are also given with negative integers. so the Maximum of the product of two minimum numbers
and the maximum number or the product of three maximum numbers wil give us the optimum result.

-4 -2 1 2 9  -> looking at the this sorted array we can say the maximum product is 72 from picking -4 -2 and 9

-4 -2 3 4 9 -> in this case the product  is 108 selecting 3 4 9

 so max_product is the two integers at the extreme end(negative integers) in a sorted array and the max element 
 in the sorted array or the product of last three elements in the sorted array.         */
 


class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i]>max1){
                int temp1 = max1;
                int temp2 = max2;
                max1 = nums[i];
                max2 = temp1;
                max3 = temp2;
            }else if(nums[i]>max2){
                int temp = max2;
                max2 = nums[i];
                max3 = temp;
            }else if(nums[i]>max3){
                max3 = nums[i];
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]<min1){
                int temp = min1;
                min1 = nums[i];
                min2 = temp; 
            }else if(nums[i]<min2){
                min2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
              
    }
}

