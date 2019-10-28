class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        // state machine
        // A[i]+A[j]+i-j = (A[i]+i) + (A[j]-j) 
        // keep tracking the largest A[i]+i as left and  A[i]+i + (A[j]-j) as left.
        int left = A[0], res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return res;
    }
}