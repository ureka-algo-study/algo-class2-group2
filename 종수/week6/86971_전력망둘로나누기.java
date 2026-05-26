package 종수.week6;
import java.util.*;

class Solution {

    static List<List<Integer>> graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 생성
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 전선 하나씩 제거
        for (int[] wire : wires) {

            int a = wire[0];
            int b = wire[1];

            // 간선 제거
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));

            visited = new boolean[n + 1];

            // 한쪽 트리 크기 계산
            int count = dfs(1);

            int diff = Math.abs(count - (n - count));

            answer = Math.min(answer, diff);

            // 간선 복구
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return answer;
    }

    static int dfs(int node) {

        visited[node] = true;

        int count = 1;

        for (int next : graph.get(node)) {

            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}

//[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]