class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] lst = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int len = lst.length;
        if(len<=1) return s;
        for(int i = len-1;i>=0;i--){
            sb.append(lst[i]);
            if(i!=0) sb.append(" ");
        }
        return new String(sb);
    }
}