class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int row = 0;row<matrix.length;row++){
            for(int col = 0;col<matrix[0].length;col++){
                if(matrix[row][col]==0){
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        for(Integer row: rows){
            for(int i =0;i<matrix[0].length;i++){
                matrix[row][i] = 0;
            }
        }
        for(Integer col: cols){
            for(int j = 0;j < matrix.length;j++){
                matrix[j][col] = 0;
            }
        }
    }
}

