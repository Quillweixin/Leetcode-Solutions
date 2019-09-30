class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        return dp(m-1,n-1,grid);
    }
    public int dp(int m,int n,int[][] grid){
        if(n==0 || m == 0) return 1; 
        grid[n][m-1] = grid[n][m-1]==0? dp(m-1,n,grid):grid[n][m-1];
        grid[n-1][m] = grid[n-1][m]==0? dp(m,n-1,grid):grid[n-1][m-1];
        return grid[n][m-1]+grid[n-1][m];
    }
}