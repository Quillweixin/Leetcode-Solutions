class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(len==0) return 1;
        if(len == 1) return nums[0]==1? 2:1;
        
        int[] count = new int[len];
        for(int i = 0; i < len;i++){
            int num = nums[i];
            if(num>0 && num<=len) count[num-1] = 1;
        }

        for(int j = 0;j < len;j++){
            if(count[j] != 1) return j+1;
        }
        return len+1;
    }
}