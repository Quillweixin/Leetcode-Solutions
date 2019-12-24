class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if(len==0) return 0;
        int prev = -1,res = 0;
        for(int i = 0; i < len;i++){
            // skip the duplicate numbers
            if(prev>=0 && prev == citations[i]) continue;
            int h = Math.min(len-i,citations[i]);
            if(h>res) res=h;
            prev = citations[i];
        }
        return res;
    }
}