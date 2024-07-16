class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        // 배열의 끝과 끝이 서로 중앙을 향해 이동해 가면서 값을 바꿈
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }
    }
}