import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        SegTree st = new SegTree(baskets);

        int placed = 0;
        for (int f : fruits) {
            int idx = st.firstAtLeast(f); // leftmost basket with capacity >= f
            if (idx != -1) {
                placed++;
                st.update(idx, Integer.MIN_VALUE); // mark used
            }
        }
        return n - placed;
    }

    static class SegTree {
        int n;
        int[] tree; // stores max over ranges

        SegTree(int[] arr) {
            n = arr.length;
            tree = new int[4*n];
            build(1, 0, n-1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            if (l == r) { tree[node] = arr[l]; return; }
            int m = (l + r) >>> 1;
            build(node<<1, l, m, arr);
            build(node<<1|1, m+1, r, arr);
            tree[node] = Math.max(tree[node<<1], tree[node<<1|1]);
        }

        // return leftmost index with value >= x, or -1 if none
        int firstAtLeast(int x) { 
            if (n == 0 || tree[1] < x) return -1;
            return firstAtLeast(1, 0, n-1, x);
        }

        int firstAtLeast(int node, int l, int r, int x) {
            if (l == r) return l;
            int m = (l + r) >>> 1;
            if (tree[node<<1] >= x) return firstAtLeast(node<<1, l, m, x);
            return firstAtLeast(node<<1|1, m+1, r, x);
        }

        void update(int idx, int val) { update(1, 0, n-1, idx, val); }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) { tree[node] = val; return; }
            int m = (l + r) >>> 1;
            if (idx <= m) update(node<<1, l, m, idx, val);
            else update(node<<1|1, m+1, r, idx, val);
            tree[node] = Math.max(tree[node<<1], tree[node<<1|1]);
        }
    }
}
