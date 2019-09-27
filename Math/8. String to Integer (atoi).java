class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        int len = str.length();
        if(len==0) return 0;
        char first = str.charAt(0);
        
        if (first != '+' && first != '-' && !Character.isDigit(first)) return 0;
        boolean neg = first == '-';
        int index = Character.isDigit(first)? 0:1;
        int result = 0;
        while(index<len){
            char digit = str.charAt(index);
            if(!Character.isDigit(digit)) break;
            if((Integer.MAX_VALUE-(digit-'0'))/10 >= result && result>=Integer.MIN_VALUE/10-(digit-'0')/10) 
            result = result*10 + (digit-'0');
            else return neg?Integer.MIN_VALUE : Integer.MAX_VALUE;
            index++;
        }
        return neg? -result:result;
    }
}