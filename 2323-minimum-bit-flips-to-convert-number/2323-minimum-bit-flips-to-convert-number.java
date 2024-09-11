class Solution {
    public int minBitFlips(int start, int goal) {
        int counter = 0;

        int XOR = start ^ goal;

        while(XOR > 0)
        {
            counter += (XOR & 1);
            XOR >>= 1;
        }

        return counter;
    }
}