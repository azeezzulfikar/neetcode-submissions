class Tree {
    int sum;
    int leftRange;
    int rightRange;
    Tree left;
    Tree right;

    public Tree(){}

    public Tree(int leftRange, int rightRange, int sum) {
        this.leftRange = leftRange;
        this.rightRange = rightRange;
        this.sum = sum;
    }
}

class SegmentTree {
    Tree root;

    public SegmentTree() {}

    public SegmentTree(int[] nums) {
        root = build(0, nums.length -1, nums);
    }

    private Tree build(int leftRange, int rightRange, int[] nums) {
        if(leftRange == rightRange) return new Tree(leftRange, rightRange, nums[leftRange]);
        int mid = (leftRange + rightRange)/2;
        Tree tree = new Tree(leftRange, rightRange, 0);
        tree.left = build(leftRange, mid, nums);
        tree.right = build(mid+1, rightRange, nums);
        tree.sum = tree.left.sum + tree.right.sum;
        return tree;
    }

    public void update(int index, int val) {
        Tree curr = root;
        update(index, val, curr);
    }

    private void update(int index, int val, Tree root) {
        if(root.leftRange == index && index == root.rightRange) {
            root.sum = val;
            return;
        }
        int mid = (root.leftRange + root.rightRange) /2;
        if(index <= mid) update(index, val, root.left);
        else if(index > mid) update(index, val, root.right);
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int L, int R) {
        Tree curr = root;
        return query(L, R, curr);
    }

    private int query(int L, int R, Tree root) {
        if(root.leftRange >= L && root.rightRange <= R) return root.sum;
        if(L > root.rightRange || R < root.leftRange) return 0;
        return query(L, R, root.left) + query(L, R, root.right);

    }

}
