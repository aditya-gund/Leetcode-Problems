class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueCharacters.add(c);
        }

        int result = 0;

        for (char ch : uniqueCharacters) {
            int left_index = -1, right_index = -1;

            // Find the first and last occurrence of the character 'ch'
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    if (left_index == -1) {
                        left_index = i; // First occurrence
                    }
                    right_index = i; // Last occurrence
                }
            }

            if (left_index != -1 && right_index != -1 && right_index > left_index) {
                // Collect unique characters between left_index and right_index
                Set<Character> st = new HashSet<>();
                for (int mid = left_index + 1; mid < right_index; mid++) {
                    st.add(s.charAt(mid));
                }
                result += st.size();
            }
        }

        return result;
    }
}
