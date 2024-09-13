class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
    int[] xorArr = new int[n];
    xorArr[0] = arr[0];
    for (int i = 1; i < n; i++) {
        xorArr[i] = xorArr[i-1] ^ arr[i];
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
        int left = queries[i][0];
        int right = queries[i][1];
        result[i] = xorArr[right] ^ (left > 0 ? xorArr[left-1] : 0);
    }
    return result;
    }
}