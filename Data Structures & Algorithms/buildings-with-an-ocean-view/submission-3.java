class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights.length == 1)
            return new int[1];
        int curr = heights.length -1;
        int next = curr;
        List<Integer> res = new ArrayList<>();
        while(curr >=0) {
            res.add(curr);
            while(next >=0) {
                if(heights[next] > heights[curr])
                    break;
                next--;
            }
            curr=next;
        }
        int[] r = new int[res.size()];
        int index= 0;
        for(int i = res.size()-1 ; i>=0; i--) {
            r[index] = res.get(i);
            index++;
        }

        return r;

    }
}