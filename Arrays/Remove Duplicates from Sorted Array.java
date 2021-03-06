class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int slow = 0;
        
        for (int i =1; i < nums.length;i++){
            if (nums[i] != nums[slow]) nums[++slow] = nums[i];
        }
        return slow+1;
 }
}