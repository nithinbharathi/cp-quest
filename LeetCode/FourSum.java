class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
              if(i>0 && nums[i] == nums[i-1])continue;
              int num = nums[i];
            for(int j=i+1;j<nums.length-2;j++){
                  if(j>i+1 && nums[j] == nums[j-1])continue;
                  int sum = target-num-nums[j];
                  int start = j+1;
                  int end = nums.length-1;
                while(start < end){
                    if(nums[start] + nums[end] == sum){
        result.add(new ArrayList<>(Arrays.asList(nums[start],nums[end],nums[j],nums[i])));
                        int curr_start = start;
                        int curr_end = end;
                        while( start < end && nums[start] == nums[curr_start]){
                            start++;
                        }
                        while(start<end && nums[end] == nums[curr_end]){
                            end--;
                        }
                    }else if(nums[start]+nums[end]>sum){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
