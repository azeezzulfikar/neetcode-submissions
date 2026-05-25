class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length();
        int n = abbr.length();
        int i=0, j=0;
        while(i < m && j < n) {
            if(abbr.charAt(j) == '0')
                return false;
            if(Character.isLetter(abbr.charAt(j))) {
                if(i < m && word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                int len = 0;
                while(j< n && Character.isDigit(abbr.charAt(j))) {
                    len = len * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i+=len;
            }
        }
    return i==m && j == n;
    }

    
}