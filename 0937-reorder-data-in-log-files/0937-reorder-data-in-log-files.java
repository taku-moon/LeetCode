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

        // 문자 리스트 정렬
        wordsList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 문자 로그에서 식별자를 제외한 문자열 값
                String o1Words = o1.substring(o1.indexOf(" ")+1);
                String o2Words = o2.substring(o2.indexOf(" ")+1);

                // 비교하는 문자열 값이 같은 경우
                if (o1Words.equals(o2Words)) {
                    // 식별자를 기준으로 정렬 -> 문자 로그 자체를 비교
                    return o1.compareTo(o2);
                } else {    // 다른 경우
                    // 문자열 값을 기준으로 정렬
                    return o1Words.compareTo(o2Words);
                }
            }
        });

        wordsList.addAll(numbersList);

        return wordsList.toArray(new String[0]);
    }
}