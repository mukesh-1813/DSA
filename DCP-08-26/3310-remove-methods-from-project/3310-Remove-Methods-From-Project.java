import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        boolean[] susp = findSus(n, k, invocations);

        // Check if any non-suspicious method invokes a suspicious method
        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];

            if (!susp[from] && susp[to]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Remove suspicious methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!susp[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean[] findSus(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] susp = new boolean[n];
        dfs(k, graph, susp);

        return susp;
    }

    public void dfs(int node, List<List<Integer>> graph, boolean[] susp) {
        susp[node] = true;

        for (int next : graph.get(node)) {
            if (!susp[next]) {
                dfs(next, graph, susp);
            }
        }
    }
}