class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int col = obstacleGrid[0].length-1;
        int row = obstacleGrid.length-1;
        // create a grid storing solutions
        int[][] grid = new int[row+1][col+1];
        return dp(obstacleGrid,grid,row,col);
    }
    
    public int dp(int[][] obstacles,int[][] grid,int row,int col){
        if(obstacles[row][col]==1) return 0;
        if(row==0&&col==0) return 1;
        if(row==0) return dp(obstacles,grid,row,col-1);
        if(col==0) return dp(obstacles,grid,row-1,col);
        
        if(grid[row-1][col]==0) 
        grid[row-1][col] = obstacles[row-1][col]==1? 0:dp(obstacles,grid,row-1,col);
        if(grid[row][col-1]==0)
        grid[row][col-1] = obstacles[row][col-1]==1? 0:dp(obstacles,grid,row,col-1);
        
        return grid[row-1][col]+grid[row][col-1];
    }
}

// DP in reversed order would be much faster!----------------

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // obstacle at the start point, return 0
        if(obstacleGrid[0][0]==1) return 0;
        
        int cols = obstacleGrid[0].length;
        int rows = obstacleGrid.length;
        // create a grid storing solutions
        int[][] grid = new int[rows][cols];
        grid[0][0] = 1;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(i==0 && j==0) continue;
                if(obstacleGrid[i][j]==1) grid[i][j] = 0;
                else if(i==0) grid[i][j] = grid[0][j-1];
                else if(j==0) grid[i][j] = grid[i-1][0];
                else grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        
        return grid[rows-1][cols-1];
    }  
}