//Time complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>result = new ArrayList<>();
        int arr[] = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            arr[nums[i]-1]++;           // hashing the elements
        }
        for(int i =0;i<nums.length;i++){
            if(arr[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }
}

//Better Approach
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer>result = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
           if(arr[Math.abs(arr[i])-1]>0) {
           arr[Math.abs(arr[i])-1] = arr[Math.abs(arr[i])-1]*-1;// marking the curr element as visited in the given array itself
           }                                                // by making them negative
        }
        for(int i =0;i<arr.length;i++){
            if(arr[i]>0){                     // elements which are not negative are the ones that were not visited
                result.add(i+1);              // so they are the missing numbers in the array
            }
        }
        return result;
        
    }
}
