class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int dummy[] = new int[m];
        for(int i=0;i<m;i++){
            dummy[i] = nums1[i];
        }
        int first =0;
        int second = 0;
        int z =0;
        while(first<dummy.length && second < nums2.length){
            if(dummy[first] < nums2[second]){
                nums1[z] = dummy[first];
                first++;
            }else{
                nums1[z] = nums2[second];
                second++;
            }
            z++;
        }
        while(first < dummy.length){
            nums1[z] = dummy[first];
            first++;
            z++;
        }
        while(second < nums2.length){
            nums1[z] = nums2[second];
            z++;
            second++;
        }
    }
}
