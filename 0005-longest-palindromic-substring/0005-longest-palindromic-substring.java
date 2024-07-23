class Solution {
    int startIdx;
    int endIdx;
    int palindromeLen;

    public String longestPalindrome(String s) {
        // 오른쪽으로 한 칸씩 이동하며 투 포인터 조사
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i + 1);  // 2칸짜리 투 포인터
            extendPalindrome(s, i, i + 2);  // 3칸짜리 투 포인터
        }

        return s.substring(startIdx, endIdx + 1);
    }

    private void extendPalindrome(String s, int start, int end) {
        // tmpXx 변수를 사용하면 start와 end 값을 추가적인 연산 없이 빠르게 파악할 수 있다.
        int tmpStart = 0;
        int tmpEnd = 0;
        int tmpLen = 0;

        // 투 포인터가 유효한 범위 내에 있고, 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        while ((start >= 0) && (end < s.length()) && (s.charAt(start) == s.charAt(end))) {
            tmpStart = start--;
            tmpEnd = end++;
            tmpLen = tmpEnd - tmpStart + 1;
        }

        // 기존의 최대 길이보다 큰 경우 값 교체
        if (tmpLen > palindromeLen) {
            startIdx = tmpStart;
            endIdx = tmpEnd;
            palindromeLen = tmpLen;
        }
    }
}