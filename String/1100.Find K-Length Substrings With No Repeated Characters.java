// typical sliding window solution
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int len = S.length();
        if(K>len) return 0;
        int res = 0;
        int left = 0,right = 0;
        Set<Character> set = new HashSet<>();
        while(right<len){
            if(set.contains(S.charAt(right))){
                set.remove(S.charAt(left++));
                continue;
            }
            set.add(S.charAt(right++));
            if(set.size()==K) {
                res++;
                set.remove(S.charAt(left++));
            }
        }
        
        return res;
    }
}

// can use a char Array instead of the hashset to improve performance
// reference from: https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/discuss/322982/Java-Sliding-Window-two-O(n)-codes-w-comments-and-analysis.

public int numKLenSubstrNoRepeats(String S, int K) {
        int[] cnt = new int[26];
        int ans = 0;
        for (int hi = 0, lo = 0; hi < S.length(); ++hi) {
            if (++cnt[S.charAt(hi) - 'a'] == 1) {
                if (hi - lo + 1 == K) {
                    ++ans;
                    --cnt[S.charAt(lo++) - 'a'];
                }
            }else {
                do {
                    --cnt[S.charAt(lo) - 'a'];
                } while (S.charAt(hi) != S.charAt(lo++));
            }
        }
        return ans;
    }