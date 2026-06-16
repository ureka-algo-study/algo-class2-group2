import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];

            graph.get(a).add(new int[]{b, 1});
            graph.get(b).add(new int[]{a, 1});
        }
        // 양방향 그래프 담기


        // 최단거리를 담을 dist 배열 생성
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 다익스트라 쓸 pq 만들기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[1] = 0; // 1에서 출발하니 1까지 거리는 0
        pq.offer(new int[]{1, 0}); // 위치, 누적거리



        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int curNode = cur[0]; // 현재위치
            int curDist = cur[1]; // //누적거리

            if (curDist > dist[curNode]) { // 갱신할 가치가 없으면 다음꺼 보기
                continue;
            }

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0]; // 다음후보
                int cost = next[1]; // 다음까지 걸리는 거리(어차피1)

                if (dist[nextNode] > curDist + cost) {
                    dist[nextNode] = curDist + cost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int maxDist = 0;
        int count = 0;


        // 가장 먼 거리
        for(int i = 1; i <= n; i ++) {
            if(dist[i] > maxDist) {
                maxDist = dist[i];
            }
        }

        // 가장 먼 거리의 노드
        for(int i = 1; i <= n; i ++) {
            if(dist[i] == maxDist) {
                count++;
            }
        }
        return count;
    }
}