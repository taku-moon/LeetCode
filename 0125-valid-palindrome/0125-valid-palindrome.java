class Solution {
    public boolean isPalindrome(String s) {
        // 문자열 s를 소문자로 변환한 후 영문자와 숫자를 제외한 나머지를 제거
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // StringBuilder를 사용하여 문자열 s 뒤집기
        String reverseS = new StringBuilder(s).reverse().toString();

        return s.equals(reverseS);
    }
}