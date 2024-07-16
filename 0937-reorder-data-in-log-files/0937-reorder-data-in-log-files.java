class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<String> numberList = new ArrayList<>();

        for (String log : logs) {
            if (log.split(" ")[1].matches("[a-zA-Z]+")) {
                wordList.add(log);
            } else {
                numberList.add(log);
            }
        }

        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.indexOf(" ")+1);
                String s2 = o2.substring(o2.indexOf(" ")+1);
                
                if (s1.equals(s2)) {
                    return o1.substring(0, o1.indexOf(" ")+1).compareTo(o2.substring(0, o2.indexOf(" ")+1));
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        wordList.addAll(numberList);

        return wordList.toArray(new String[0]);
    }
}