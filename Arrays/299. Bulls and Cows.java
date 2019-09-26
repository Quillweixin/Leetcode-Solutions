class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int len = secret.length();
        // create a buckets array to store the number of 0-9 in two strings
        int[] counts = new int[10];
        int[] countg = new int[10];
        
        // check bulls first!
        for(int i =0;i<len;i++){
            int n = secret.charAt(i) - '0';
            int m = guess.charAt(i) - '0';
            if(m == n) {
                bulls++;
            }else{
                counts[n]++;
                countg[m]++;
            }
        }
        // check cows!
        for(int j = 0; j<10;j++){
            cows += Math.min(counts[j],countg[j]);
        }
        
        return String.format("%dA%dB",bulls,cows);
    }
}

// one pass solution--------------------------
// The idea is to iterate over the numbers in secret and in guess and 
// count all bulls right away. For cows maintain an array that stores 
// count of the number appearances in secret and in guess. Increment cows
// when either number from secret was already seen in guest or vice versa.
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}

// https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
