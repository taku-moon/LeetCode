class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(1, n, k, new ArrayList<>(), answer);

        return answer;
    }

    public void dfs(int start, int n, int k, List<Integer> tmp, List<List<Integer>> answer) {
        if (tmp.size() == k) {
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(i+1, n, k, tmp, answer);
            tmp.removeLast();
        }
    }
}