class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start =0;
        int end = numbers.length-1;
        int arr[] = new int[2];
        while(start < end){
            if(numbers[start]+numbers[end] == target){
                arr[0] = start+1; arr[1] = end+1;
                break;
            }
            else if(numbers[start] + numbers[end]>target){
                end--;
            }
            else {
                start++;
            }
        }
        return arr;
    }
}
