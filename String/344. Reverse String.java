class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        if(len<=1) return;
        for (int i=0; i< len/2;i++){
            char tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
        return;
    }
}