public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    sink(grid,i,j);
                }
                
            }    
        }
        
       return num; 
    }
    
    public void sink(char[][] grid, int row,int col){
        int col_len = grid.length;
        int row_len = grid[0].length;
        if(row<0 || col<0 || row>=col_len || col >= row_len || grid[row][col] == '0'){
            return;
        }  
        grid[row][col] = '0';
        sink(grid,row+1,col);
        sink(grid,row,col+1);
        sink(grid,row-1,col);
        sink(grid,row,col-1);
    }
}