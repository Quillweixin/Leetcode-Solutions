class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // start from an empty set
        res.add(new ArrayList<Integer>());
        for(int i = 0; i<nums.length;i++){
            List<List<Integer>> toAdd = new ArrayList<List<Integer>>();
            for(int j = 0; j<res.size();j++){
                // add a new set with nums[i] in it
                List<Integer> lst = new ArrayList<>(res.get(j));
                lst.add(nums[i]);
                toAdd.add(lst);
            }
            res.addAll(toAdd);
        }
        return res;
    }
}