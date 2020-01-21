// DP solution
/*
Imagine we only need one more number to reach target, this number can be any one in the array, right? So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i]
https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
*/
class Solution {
    private int[] dp;
    
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        int res = dp(nums,target);
        return res;
    }
    
    private int dp(int[] nums, int target){
        if(dp[target] != -1){
            return dp[target];
        }
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            if(target-nums[i]>=0){
                res += dp(nums,target-nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}

// Follow up 
/* This code doesn't work when target is too big, since it will throw a java.lang.OutOfMemoryError exception.

It does not pass the test case for: nums = [10000000, 20000000, 30000000], target = 320000000, because the DP array will use too much useless space.

Using a HashMap to record during recursion will be helpful.
*/
public int combinationSum4(int[] nums, int target) {
    return helper(nums, target, new HashMap<Integer, Integer>());
} 
    
private int helper(int[] nums, int target, Map<Integer, Integer> map) {
    if (target < 0) return 0;
    if (target == 0) return 1;
    if (map.containsKey(target)) return map.get(target);
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        int cnt = helper(nums, target - nums[i], map);
        if (target >= nums[i]) map.put(target - nums[i], cnt);
        res += cnt;
    }
    return res;
}    
