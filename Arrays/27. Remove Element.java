class Solution {
    public int removeElement(int[] nums, int val) {
        // use two pointers to implement in-place manipulation
        int len = nums.length;
        int left = 0, right = len -1;
        while(left<=right){
            if(nums[left] == val){
                // swap value
                nums[left] = nums[right];
                right--;
                len--;
            }else{
                left++;
            }
        }
        return len;
    }
}