class Solution {
    public String largestGoodInteger(String num) {
        int l = 0, r = 1;
        String maxNum = "";
        while(l < num.length()) {
            StringBuilder currNum = new StringBuilder();
            currNum.append(num.charAt(l));
            r = l + 1;
            while(r < num.length() && num.charAt(l) == num.charAt(r) && r - l < 3) {
                currNum.append(num.charAt(r));
                r++;
            }
            if(currNum.length() == 3) {
                maxNum = maxNum.compareTo(currNum.toString()) < 0 ? currNum.toString() : maxNum;
            }
            l++;
        }

        return maxNum;
    }
}