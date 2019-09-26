class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if(len == 0) return -1;
        if(len == 1) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i< len;i++){
            char c = s.charAt(i);
            if(map.get(c) == null) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        for(int j = 0; j < len;j++){
            char c = s.charAt(j);
            if(map.get(c) == 1) return j;
        }
        return -1;
    }
}

// using array instead of hashmap, would be faster.

class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) {
            return -1;
        }
        int[] c = new int[26];
        char[] s1 = s.toCharArray();
        
        for(int i =0; i < s1.length; ++i) {
            c[s1[i] - 'a']++;
        }
        
        
        for(int i =0; i < s1.length; ++i) {
            if(c[s1[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

// https://leetcode.com/problems/first-unique-character-in-a-string/discuss/157955/Java-9-ms-beats-97.66