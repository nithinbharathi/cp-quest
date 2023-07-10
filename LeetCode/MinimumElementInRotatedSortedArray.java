class Solution {
    public int findMin(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int l = 0;
		int r = arr.length-1;
		int result = -1;
		while(l<=r) {
			int mid = (l+r)/2;
            if(r == mid){
                result = arr[mid];
                break;
            }
			if(arr[mid]<=arr[r]) {
				r = mid;
			}else {
				l = mid+1;
			}
					
		}
        return result;
    }
}
