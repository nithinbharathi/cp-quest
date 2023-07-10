//Time Complexity: O(n)
//Space Complexity: o(1)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ptr1 =0;
        int ptr2 =0;
        int curr_result = 1;
        int count =0;
        while(ptr1 < nums.length){
            curr_result*=nums[ptr1];
            if(curr_result<k){
               count = count + (ptr1-ptr2+1); 
            }
            while(ptr2<nums.length && curr_result>=k){
                curr_result = curr_result/nums[ptr2];
                ptr2++;
                if(curr_result<k)count = count+(ptr1-ptr2)+1;
            }
            
            ptr1++;
            
        }
        return count;
    }
}
