class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
