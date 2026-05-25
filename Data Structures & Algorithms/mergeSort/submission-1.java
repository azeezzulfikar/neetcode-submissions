// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
        if(end - start + 1 <=1) return pairs;
        int mid = (start + end) / 2;
        mergeSort(pairs, start, mid);
        mergeSort(pairs, mid + 1, end);

        merge(pairs, start, mid, end);

        return pairs;
    }

    private void merge(List<Pair> pairs, int start, int mid, int end) {
        List<Pair> left = new ArrayList<>(pairs.subList(start, mid+1));
        List<Pair> right = new ArrayList<>(pairs.subList(mid+1, end +1));

        int l=0, r=0, index = start;
        while(l < left.size() && r < right.size()) {
            if(left.get(l).key <= right.get(r).key) {
                pairs.set(index, left.get(l));
                l++;
            } else {
                pairs.set(index, right.get(r));
                r++;
            }
            index++;
        }

        while(r < right.size()) {
            pairs.set(index, right.get(r));
            index++;
            r++;
        }

        while(l < left.size()) {
            pairs.set(index, left.get(l));
            l++;
            index++;
        }
    }
}
