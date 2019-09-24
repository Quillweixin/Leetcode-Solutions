class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len<=2) return len;
        
        int left = 0, prev = nums[0], count = 0;
        for(int i = 0; i < len; i++){
            if(count >= 2 && prev == nums[i]) continue;
            else if(count >= 2 && prev != nums[i]){
                nums[left] = nums[i];
                prev = nums[i];
                left ++;
                count = 1;
            }else{
                nums[left] = nums[i];
                left ++;
                if(prev == nums[i]) count ++;
                else{
                    count = 1;
                    prev = nums[i];
                }
            } 
        }
        return left;
    }
}

// short version 

// public int removeDuplicates(int[] nums) {
//     int i = 0;
//     for (int n : nums)
//         if (i < 2 || n > nums[i-2])
//             nums[i++] = n;
//     return i;
// }

