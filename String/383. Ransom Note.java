class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // use an array to count and store the number of every char in ransom
        int[] ransom = new int[26];
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        for(char c : r){
            ransom[c-'a'] ++;
        }
        
        for(char c : m){
            ransom[c-'a']--;
        }
        
        for(int n : ransom){
            if(n > 0) return false;
        }
        
        return true;
    }
}