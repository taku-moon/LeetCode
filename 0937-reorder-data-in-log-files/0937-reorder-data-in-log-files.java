class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> wordsList = new ArrayList<>();
        List<String> numbersList = new ArrayList<>();

        for (String log : logs) {
            // 문자열(log)을 공백을 기준으로 쪼개고
            // 그 중 1번 인덱스에 위치한 문자열 값의 첫 번째 문자만 뽑아내
            // 그 문자가 영어이면 문자 리스트
            if (Character.isAlphabetic(log.split(" ")[1].charAt(0))) {
                wordsList.add(log);
            } else {    // 숫자이면 숫자 리스트에 할당
                numbersList.add(log);
            }
        }

        // 문자 리스트 정렬 -> 람다 표현식 사용
        wordsList.sort((s1, s2) -> {
            // 식별자[0]와 식별자 외 나머지 부분[1]으로 쪼개기
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // 식별자 외 나머지 부분의 내용이 같다면
            if (s1x[1].equals(s2x[1])) {
                // 식별자를 기준으로 비교
                return s1x[0].compareTo(s2x[0]);
            } else {    // 다르다면
                // 내용을 기준으로 비교
                return s1x[1].compareTo(s2x[1]);
            }
        });

        wordsList.addAll(numbersList);

        return wordsList.toArray(new String[0]);
    }
}