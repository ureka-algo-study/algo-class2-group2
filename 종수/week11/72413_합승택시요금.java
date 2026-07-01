package 종수.week11;

import java.util.*;

class Solution {

    public int solution(int n, int s, int a, int b, int[][] fares) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }

        int[] distS = dijkstra(s, n, graph);
        int[] distA = dijkstra(a, n, graph);
        int[] distB = dijkstra(b, n, graph);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer,
                    distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }

    private int[] dijkstra(int start, int n, List<List<int[]>> graph) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1]
        );

        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) {
                continue;
            }

            for (int[] next : graph.get(now)) {

                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = cost + nextCost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[]{nextNode, newCost});
                }
            }
        }

        return dist;
    }
}