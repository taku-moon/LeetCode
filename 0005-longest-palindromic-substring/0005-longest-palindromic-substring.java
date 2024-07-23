class Solution {
    int startIdx;
    int endIdx;
    int palindromeLen;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(startIdx, endIdx + 1);
    }

    private void extendPalindrome(String s, int start, int end) {
        int tmpStart = 0;
        int tmpEnd = 0;
        int tmpLen = 0;

        while ((start >= 0) && (end < s.length()) && (s.charAt(start) == s.charAt(end))) {
            tmpStart = start--;
            tmpEnd = end++;
            tmpLen = tmpEnd - tmpStart + 1;
        }

        if (tmpLen > palindromeLen) {
            startIdx = tmpStart;
            endIdx = tmpEnd;
            palindromeLen = endIdx - startIdx + 1;
        }
    }
}