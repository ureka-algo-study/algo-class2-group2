import java.util.*;

class Solution {

    static int solution = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {

        // 1. 그래프 만들기
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        //2. 하나씩 잘라서 개수세기
        for(int[] wire : wires) { //자르기
            graph.get(wire[0]).remove( (Integer) wire[1]);
            graph.get(wire[1]).remove( (Integer) wire[0]);

            // 송전탑의 개수 세기 로직 작성
            int count = 1; //자기 자신 포함

            boolean[] visited = new boolean[n+1];

            Deque<Integer> q = new ArrayDeque<>();

            q.add(wire[0]);
            visited[wire[0]] = true;

            while(!q.isEmpty()) {
                int poll = q.poll();
                for(int i : graph.get(poll)) {
                    if(!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                        count++;
                    }

                }
            }

            int opposite = n - count; // 남은 반대쪽 송전탑의 개수
            solution = Math.min(solution, Math.abs(count - opposite));

            // 자른 전선 복구
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return solution;
    }
}