class Solution {
    public int compareVersion(String version1, String version2) {
        int version1_num = 0;
        int version2_num = 0;
        int i=0,j=0;
        while(i <version1.length() || j <version2.length()){
            while(i<version1.length() && version1.charAt(i) != '.'){
                version1_num = version1_num*10+(version1.charAt(i)-'0');
                i++;
            }
            while(j<version2.length() && version2.charAt(j) != '.'){
                version2_num = version2_num*10+(version2.charAt(j)-'0');
                j++;
            }
            if(version1_num > version2_num)return 1;
            if(version2_num>version1_num)return -1;
            version1_num = version2_num = 0;
            i++;
            j++;
        }
        return 0;
    }
}
