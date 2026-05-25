class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(char c: s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        boolean isPresent = false;

        for(int r = 0; r < s2.length(); r++) {
            l = r;
            if(s1Map.containsKey(s2.charAt(l))) {
                Map<Character, Integer> temp = new HashMap<>(s1Map);
                while(l < s2.length() && temp.containsKey(s2.charAt(l))) {
                    int count = temp.get(s2.charAt(l));
                    if(count == 1) {
                        temp.remove(s2.charAt(l));
                    } else {
                        temp.put(s2.charAt(l), count - 1);
                    }
                    l++;
                }
                if(temp.isEmpty()) return true;
            }
            
        }

        return false;

    }
}
