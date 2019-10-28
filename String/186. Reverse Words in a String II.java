class Solution {
    // in-place solution
    public void reverseWords(char[] s) {
        // first reverse the entire array
        // and then reverse the words one by one
        int len = s.length;
        if(len<=1) return;
        int left = 0, right = len-1;
        char tmp = ' ';
        while(left<right){
            tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
        left = 0;
        right = 0;
        while(right <= len){
            if(right < len && s[right] != ' '){
                right++;
                continue;
            }
            int end = right-1;
            while(left < end){
                tmp = s[end];
                s[end] = s[left];
                s[left] = tmp;
                end--;
                left++;
            }
            right++;
            left = right;
        }
        
    }
}