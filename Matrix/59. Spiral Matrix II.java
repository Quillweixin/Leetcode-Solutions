class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0, col = 0;
        int dx = 1,dy = 0;
        int count = 1;
        while(count<=n*n){
            res[row][col] = count;
            // when dx == 0, no need to make horizontal turn
            if( dx !=0 && (col+dx>n-1 || col+dx<0 || res[row][col+dx] !=0)){
                dy = dx;
                dx = 0;
            }else if (dy!=0 && (row+dy>n-1 || row+dy<0 || res[row+dy][col] !=0)){
                // when dy == 0 no need to make vertical turn
                dx = -dy;
                dy = 0;
            }
            
            row+=dy;
            col+=dx;
            count++;
        }
        return res;
    }
}