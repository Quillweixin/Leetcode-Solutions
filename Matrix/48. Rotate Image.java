class Solution {
    // brilliant solution from others
    public void rotate(int[][] matrix) {
        int n = matrix.length;
		// l is the side length of the matrix we are processing
        for(int l = n; l > 1; l -= 2){
		    // lo is the start index of the matrix we are processing
            int lo = (n-l)/2;
			// hi is the end index of the matrix we are processing
            int hi = lo + l -1;
            for(int i = 0; i < l-1; i++){
			    // move number on one side to the other side clockwise
                int temp = matrix[hi-i][lo];
                matrix[hi-i][lo] = matrix[hi][hi-i];
                matrix[hi][hi-i] = matrix[lo+i][hi];
                matrix[lo+i][hi] = matrix[lo][lo+i];
                matrix[lo][lo+i] = temp;
            }
        }
        return;
    }
    
}

// https://leetcode.com/problems/rotate-image/discuss/247174/Easy-Java-solution-with-explanation-processing-the-matrix-from-outer-to-inner