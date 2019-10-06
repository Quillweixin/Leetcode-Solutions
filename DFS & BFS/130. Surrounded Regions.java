class Solution {
    static int rows;
    static int cols;
    //Mark border O and adjacent O as A. Then change all O to X and A to O.
    public void solve(char[][] board) {
        rows = board.length;
        if(rows==0) return;
        cols = board[0].length;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if((row==0 || row==rows-1 || col==0 || col==cols-1) && board[row][col]=='O') dfs(board,row,col);
            }
        }
        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='A') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board,int row,int col){
        if(row <0 || col<0 || row>=rows || col>=cols || board[row][col]!='O') return;
        board[row][col] = 'A';
        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
}