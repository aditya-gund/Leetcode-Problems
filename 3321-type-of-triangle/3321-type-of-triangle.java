class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        StringBuilder sb = new StringBuilder();

        // Optional: Check for triangle validity
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        if (a == b && b == c) {
            sb.append("equilateral");
        } else if (a != b && b != c && a != c) {
            sb.append("scalene");
        } else {
            sb.append("isosceles");
        }

        return sb.toString();
    }
}
