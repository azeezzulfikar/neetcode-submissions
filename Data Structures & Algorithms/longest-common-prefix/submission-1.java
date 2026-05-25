class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s1 = strs[0];
        int minLen = s1.length();
        for(int i=1; i< strs.length; i++) {
            int j=0;
            while(j < strs[i].length() && j < s1.length() && strs[i].charAt(j) == s1.charAt(j)) {
                j++;
            }
            minLen = Math.min(j, minLen);
        }
        
        return minLen > 0 ? s1.substring(0, minLen) : "";
    }
}