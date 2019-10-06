class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) return res;
        int cols = matrix[0].length;
        int round = 0;
        // read from outter circle to inner circle
        while(rows-2*round>0 && cols-2*round>0){
            // read the top row
            for(int i = round;i < cols-round;i++){
                res.add(matrix[round][i]);
            }
            
            if(rows-2*round>1){
                // read the right column
                for(int i = round+1;i<rows-round;i++){
                    res.add(matrix[i][cols-round-1]);
                }
            }else break;
            
            if(cols-2*round>1){
                // read the bottom row
                for(int i = cols-round-2;i>= round;i--){
                    res.add(matrix[rows-round-1][i]);
                }
            }else break;
            if(rows-2*round>2){
                // read the left column
                for(int i = rows-round-2;i>=round+1;i--){
                    res.add(matrix[i][round]);
                }
            }else break;
            round++;
        }
        return res;
    }
}