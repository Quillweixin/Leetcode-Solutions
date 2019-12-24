class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len ==0 ) return 0;
        int res = 0;
        for(int i = 0;i<len;i++){
            int h = Math.min(len-i,citations[i]);
            if(h>res) res = h;
        }
        return res;
    }
}

// using binary search
/*
    Given a sorted list citations of size n in ascending order, 
    one is asked to find the first number citations[i] which meets 
    the constraint of citations[i] >= n - i.
*/

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len ==0 ) return 0;
        int left = 0,right = len-1;
        while(left<=right){    // * important!
            int mid = left+(right-left)/2;
            if(citations[mid]>len-mid){
                right = mid-1;
            }else if(citations[mid]==len-mid){
                return citations[mid];
            }else{
                left = mid+1;
            }
        }
        return len-left; // if all elements are 0, it will return 0.
    }
}