class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        if(canTrans(beginWord,endWord)) return 2;
        
        Queue<String> queue = new LinkedList<>();
        Map<String,Integer> minStep = new HashMap<>();
        // tracking the number of elements in this level and next level.
        int curlevel = 1, nextlevel = 0;
        int step = 1;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            String str = queue.poll();
            curlevel--;
            // reach the endWord
            if(str.equals(endWord)) return step;
            for(String word : wordList){
                if(!canTrans(str,word)) continue;
                if(minStep.get(word) != null && minStep.get(word) <= step) continue;
                queue.add(word);
                nextlevel++;
                minStep.put(word,step);
            }
            // move forward to next level
            if(curlevel==0) {
                step++;
                curlevel = nextlevel;
                nextlevel = 0;
            }
        }
        return 0;
    }
    
    public boolean canTrans(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int count =0;
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
            if(count>1) return false;
        }
        return true;
    }
}


// ------------------------------------------------
// elegant solution from:
// https://leetcode.com/problems/word-ladder/discuss/281178/java-9ms-bidirection-bfs-solution-which-beats-100-with-detailed-explanation
/** explanation:
1. Search from entry and exit simultaneously. when entry and exit meets, stop bfs. To do so, we need two queues to save the current search status of entry and exit respectively.
2. Each step we pick the queue with less elements to implement bfs. Less elements means less time to traverse.
3. Replace queue with set so that we can judge whether entry and exit meets in O(1) time.
4. Remove visited word from wordList to decrease the search time
**/
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<String>(wordList);
    if( !wordSet.contains(endWord) )
        return 0;
    // 3. Use set instead of queue during bfs
    Set<String> forwardSet = new HashSet<String>(); 
    Set<String> backwardSet = new HashSet<String>();
    forwardSet.add(beginWord);
    backwardSet.add(endWord);
    wordSet.remove(endWord);
    wordSet.remove(beginWord);
    // 1. Search from entry and exit simultaneously
    return transform(forwardSet, backwardSet, wordSet);
}

public int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
    Set<String> newSet = new HashSet<String>();
    for(String fs : forwardSet) {
        char wordArray[] = fs.toCharArray();
        for(int i = 0; i < wordArray.length; i++) {
            for(int c = 'a'; c <= 'z'; c++) {
                char origin = wordArray[i];
                wordArray[i] = (char) c;
                String target = String.valueOf(wordArray);
                if( backwardSet.contains(target) )
                    return 2; // stop bfs when entry and exits meet
                else if( wordSet.contains(target) && !forwardSet.contains(target) ) {
                    wordSet.remove(target); // 4. Remove visited word from wordList to decrease the search time
                    newSet.add(target);
                }
                wordArray[i] = origin;
            }
        }
    }
    if( newSet.size() == 0 )
        return 0;
    forwardSet = newSet;
    // 2. Pick the queue with less elements to bfs
    int result = forwardSet.size() > backwardSet.size() ? 
        transform(backwardSet, forwardSet, wordSet) : transform(forwardSet, backwardSet, wordSet);
    return result == 0 ? 0 : result + 1;
}