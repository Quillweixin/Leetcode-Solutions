class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int len = nums.length;
        int pivot = 0;
        if(len == 0) return -1;
        if(len == 1) return nums[0]==target? 0:-1;
        // find out where is the pivot value
        for(int i =0;i<len-1;i++){
            if(nums[i]>nums[i+1]) {
                pivot = i+1;
                break;
            }
        }

        if(pivot == 0) res = binarySearch(nums,0,len-1,target);
        else if(pivot == len-1 && nums[pivot] == target) return pivot;
        else if(pivot == len-1 && nums[pivot]!=target) res=binarySearch(nums,0,len-2,target);
        else if(nums[len-1]>=target) res = binarySearch(nums,pivot,len-1,target);
        else res = binarySearch(nums,0,pivot-1,target);
        return res;
    }
    private int binarySearch(int[] nums, int left,int right,int target){
        if(left>=right & nums[left] != target) return -1; 
        int mid = left +(right-left)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < target) return binarySearch(nums,mid+1,right,target);
        else return binarySearch(nums,left,mid-1,target);
    }
}