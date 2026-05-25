class Solution {
    public String minWindow(String s, String t) {
        StringBuilder minLength = new StringBuilder(s).append("a");
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for(int i=0; i< s.length(); i++) {
            if(tMap.containsKey(s.charAt(i))) {
                int r = i;
                Map<Character, Integer> temp = new HashMap<>(tMap);
                StringBuilder currLen = new StringBuilder();
                while(!temp.isEmpty() && r < s.length()) {
                    currLen.append(s.charAt(r));
                    if(temp.containsKey(s.charAt(r))) {
                        temp.put(s.charAt(r), temp.get(s.charAt(r)) - 1);
                        if(temp.get(s.charAt(r)) == 0) temp.remove(s.charAt(r));
                    }
                    r++;
                }
                if(temp.isEmpty()) {
                    minLength = currLen.length() < minLength.length() ? new StringBuilder(currLen) : new StringBuilder(minLength);
                }
            }
        }

        return minLength.length() == s.length() + 1 ? "" : minLength.toString();

    }
}
