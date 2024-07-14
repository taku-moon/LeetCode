class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        StringBuilder sb = new StringBuilder(s);
        String reverseS = sb.reverse().toString();

        return s.equals(reverseS);
    }
}