class Solution {
    public int reverse(int x) {
        boolean neg = (x < 0);
        int val = Math.abs(x);
        int result = 0;
        while (val>0){
            int digit = val % 10;
            // check if it would overdlow
            if(result>(Integer.MAX_VALUE-digit)/10) return 0;
            result = 10* result+digit;
            val/=10;
        }
        return neg? 0-result: result;
    }
}