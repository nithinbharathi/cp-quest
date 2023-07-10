//Brute Force - TLE!!
//Time Complexity: O(n*n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
//--------------------------------------------------------------------------------------------------------------------------
//Better Approach - Hashing HashMap (or) HashSet
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer>set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i])){
                result.add(nums[i]);
            }
            set.add(nums[i]);
        }
        return result;
    }
}

//--------------------------------------------------------------------------------------------------------------------------
//Another Approach - Sorting
//Time Complexity: O(n*log(n))
//Space Complexity: O(1)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
       Arrays.sort(nums);
        for(int i =1;i<nums.length;i++){
           if(nums[i] == nums[i-1])result.add(nums[i]);
        }
        return result;
    }
}

//--------------------------------------------------------------------------------------------------------------------------
//Efficient Approach
//Time Complexity:O(n)
//Space: O(1)

/* Given the fact that each element in the array will be <=n we can use the given array as a hash table and mark each number
by visiting the corresponding index and making it negative so whenever we visit an element we make the element at that 
index as negative meaning it is visited once we encounter another element who has already been visited(if it is already negative)
then we know that has already occured so we add it to our result array. */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
       for(int i =0;i<nums.length;i++){
           if(nums[Math.abs(nums[i])-1]>0){
            nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*-1;

           }else{
               result.add(Math.abs(nums[i]));
           }
       }
        return result;
    }
}
