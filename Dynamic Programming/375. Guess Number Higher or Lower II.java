class Solution {
    public int getMoneyAmount(int n) {
        // special case
        if(n<=2) return n-1;
        int[][] dp = new int[n+1][n+1];
        return helper(1,n,dp);

    }
    
    public int helper(int start, int n, int[][] dp){
        if(start==n) return 0;
        if(dp[start][n]!= 0) return dp[start][n];
        
        int min = Integer.MAX_VALUE,tmp=0;
        for(int pivot = start;pivot<n;pivot++){
            if(pivot==start) tmp = pivot+helper(pivot+1,n,dp);
            else tmp = pivot+Math.max(helper(start,pivot-1,dp),helper(pivot+1,n,dp));
            if(tmp<min) min = tmp;
        }
        dp[start][n] = min;
        return min;
    }
}

// store the "dp" array as a member variavle can improve the efficiency a little bit