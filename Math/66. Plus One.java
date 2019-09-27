class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        digits = digitPlus(digits,index);
        return digits;
    }
    
    private int[] digitPlus(int[] digits,int index){
        if(index<0){
            int len = digits.length+1;
            int[] extend = new int[len];
            extend[0] = 1;
            for (int i = 1;i<len;i++){
                extend[i] = digits[i-1];
            }
            return extend;
        }
        
        digits[index]++;
        if(digits[index]>=10){
            digits[index]-=10;
            index--;
            digits = digitPlus(digits,index);
        }
        return digits;
    }
}

// most elegant solution that i have ever seen
// https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}