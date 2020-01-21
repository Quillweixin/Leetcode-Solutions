// using bucket sort
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Integer key : map.keySet()){
            if(buckets[map.get(key)]==null){
                buckets[map.get(key)] = new ArrayList<>();
            }
            buckets[map.get(key)].add(key);
        }
        
        for(int i = buckets.length-1;i>0 && res.size()<k;i--){
            if(buckets[i]==null) continue;
            res.addAll(buckets[i]);
        }
        return res;
    }
}

// regular solution for TopK problems is using heap sort.
// reference from: https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // define the comparator of the heap.
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
