class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s: strs) {
            res.append(s.length()).append("#").append(s);
        }

        return res.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        System.out.println(str);
        while(str.length() > 0) {
            System.out.println(str);
            int len = 0;
            int i=0;
            while(str.charAt(i) != '#') {
                len = len*10 + Integer.parseInt(str.substring(i, i+1));
                i++;
            }
            res.add(str.substring(i+1, i+len+1));
            str = str.substring(i+len+1);
        }

        return res;
    }
}
