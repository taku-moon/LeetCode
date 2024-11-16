class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(1, n, k, new ArrayList<>(), answer);

        return answer;
    }

    public void dfs(int start, int n, int k, ArrayList<Integer> tmp, List<List<Integer>> answer) {
        if (k == 0) {
            answer.add(tmp.stream().collect(Collectors.toList()));   
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(i+1, n, k-1, tmp, answer);
            tmp.removeLast();
        }
    }
}