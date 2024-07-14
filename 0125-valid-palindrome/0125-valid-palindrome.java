class Solution {
    public boolean isPalindrome(String s) {
        // 문자열 s는 대소문자를 구분하지 않음 -> 소문자 또는 대문자로 변경
        s = s.toUpperCase();

        int left = 0;
        int right = s.length() - 1;

        // 왼쪽 끝과 오른쪽 끝이 서로 중앙으로 이동해 나가며 겹치는 지점에 도달하면 종료
        while (left < right) {
            // 해당 위치의 문자 추출
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // 추출한 문자가 영어 또는 숫자가 아니라면 한 칸씩 이동
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {    // 추출한 문자가 유효한 문자일 때
                // 서로 다른 문자라면 팰린드롬 탈락
                if (leftChar != rightChar) {
                    return false;
                }
                // 서로 같은 문자라면 한 칸씩 이동하여 다음 문자 비교
                left++;
                right--;
            }
        }

        // while 문이 무사히 종료될 경우 팰린드롬이 맞음
        return true;
    }
}