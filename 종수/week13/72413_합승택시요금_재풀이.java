package 종수.week13;

import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static List<Node>[] graph;
    static int n;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 택시 길은 양방향
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        // 출발지, A 목적지, B 목적지에서 각각 최단거리 구하기
        int[] sDist = dijkstra(s);
        int[] aDist = dijkstra(a);
        int[] bDist = dijkstra(b);

        int answer = Integer.MAX_VALUE;

        // i까지 같이 타고 간 다음 각자 갈라진다고 생각
        for (int i = 1; i <= n; i++) {
            int total = sDist[i] + aDist[i] + bDist[i];

            if (total < answer) {
                answer = total;
            }
        }

        return answer;
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 이미 더 짧은 거리로 갱신된 적이 있으면 넘김
            if (now.cost > dist[now.num]) {
                continue;
            }

            for (Node next : graph[now.num]) {
                int nextCost = now.cost + next.cost;

                if (nextCost < dist[next.num]) {
                    dist[next.num] = nextCost;
                    pq.add(new Node(next.num, nextCost));
                }
            }
        }

        return dist;
    }
}