class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        if(len<=1) return s;
        char[] lst = s.toCharArray();
        int left = 0, right = len-1;
        Character[] arr = {'a','A','e','E','i','I','o','O','u','U'};
        Set<Character> vowels = new HashSet(Arrays.asList(arr));
        char tmp = ' ';
        while(left<right){
            while(left<len && !vowels.contains(lst[left])){left++;}
            while(right>0 && !vowels.contains(lst[right])){right--;}

            if(left>=right) break;
            tmp = lst[right];
            lst[right] = lst[left];
            lst[left] = tmp;
            left++;
            right--;
        }

        return new String(lst);
    }
}