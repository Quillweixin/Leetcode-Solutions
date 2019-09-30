class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int prevprev = 1, prev = 2;
        int result = 0;
        for(int i = 3;i<=n;i++){
            result = prev+prevprev;
            prevprev = prev;
            prev = result;
        }
        return result;
    }
}