public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        Set<String> set = new HashSet(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        helper(s,set,dp);
        return dp[s.length()];
    }
    
    public void helper(String s, Set<String> set, boolean[] dp){
        for(int end = 1;end<=s.length();end++){
            for(int start = 0;start<end;start++){
                if(dp[start] && set.contains(s.substring(start,end))){
                    dp[end] = true;
                    break;
                }
            }
        }
    }
}