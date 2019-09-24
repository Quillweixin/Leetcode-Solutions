class Solution {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int len2 = needle.length();
        if(len < len2) return -1;
        if(len2 == 0) return 0;
        
        char start = needle.charAt(0);
        for(int i = 0; i <= len-len2; i++){
            if(haystack.charAt(i) != start) continue;
            boolean valid = true;
            for(int j =0; j < len2;j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) valid = false;
            }
            if(valid) return i;
        }
        return -1;
    }
}
