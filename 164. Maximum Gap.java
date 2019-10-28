// O(n*logn) solution.
class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len<2) return 0;
        if(len==2) return Math.abs(nums[0]-nums[1]);
        
        Arrays.sort(nums);
        int res = 0;
        for(int i = 1;i<len;i++){
           if(nums[i]-nums[i-1]>res) res = nums[i] - nums[i-1];
        }
        return res;
    }
}

// linear time complexity solution using radix sort.
//--------------------------------------------------------
class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len<2) return 0;
        if(len==2) return Math.abs(nums[0]-nums[1]);
        
        // find out the largest num and its number of digits.
        int max = findMax(nums);
        
        // radix sort (do counting sort on different digits)
        int[] sorted = radixSort(nums,max);
        
        // find the largest gap.
        int res = 0;
        for(int i = 1;i<len;i++){
            if(sorted[i]-sorted[i-1]>res) res = sorted[i]-sorted[i-1];
        }
        return res;
    }
    
    public int findMax(int[] nums){
        int res = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]>res) res = nums[i];
        }
        return res;
    }
    
    public int[] radixSort(int[] nums,int max){
        // int[] res = nums.clone();
        for(int i = 1;max/i>0;i*=10){
            countingSort(nums,i,10);
        }
        return nums;
    }
    
    void countingSort(int[] arr, int exp, int base){
        int n = arr.length;
        int[] output = new int[n]; //output array
        int i;
        //Count values between [0,base-1]
        int[] count = new int[base];
        //By default all values are set to 0 (no need for Arrays.fill(count, 0))        
        //Get counts
        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        //Skip the first (there is nothing to the left of the first element to add)
        for ( i = 1; i < base; i++){
             count[i] += count[i-1];
        }
        
        for ( i = n-1; i>= 0; i--)
           output[--count[(arr[i]/exp)%10]] = arr[i]; //Put the item in it's correct spot, then decrement it
        
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
}