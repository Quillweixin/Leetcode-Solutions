class Solution {
    public int compareVersion(String version1, String version2) {
        // in regex, "." means any character, so a "\\" is needed.
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int common_len = Math.min(arr1.length,arr2.length);

        int i = 0;
        for(; i<common_len;i++){
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[i]);
            if(num1 != num2) return num1>num2? 1:-1;
        }
        if(arr1.length == arr2.length) return 0;
        if(arr1.length > arr2.length){
            for(;i<arr1.length;i++){
                if(Integer.parseInt(arr1[i])!=0) return 1;
            }
        }
        if(arr1.length < arr2.length){
            for(;i<arr2.length;i++){
                if(Integer.parseInt(arr2[i])!=0) return -1;
            }
        }
        return 0;
    }
}

// more elegant code from:
// https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution.

public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");
    
    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
        Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
        Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
        int compare = v1.compareTo(v2);
        if (compare != 0) {
            return compare;
        }
    }
    
    return 0;
}
