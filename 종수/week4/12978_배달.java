package 종수.week4;

// 난 실패작이야
import java.util.*;

class Solution {

    class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int N, int[][] road, int K) {

        ArrayList<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프 저장
        for (int i = 0; i < road.length; i++) {

            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            int now = current.to;
            int nowCost = current.cost;

            // 이미 더 짧은 경로가 있으면 스킵
            if (dist[now] < nowCost) {
                continue;
            }

            for (Node next : graph[now]) {

                int nextNode = next.to;
                int nextCost = next.cost;

                // 더 짧은 거리 발견
                if (dist[nextNode] > nowCost + nextCost) {

                    dist[nextNode] = nowCost + nextCost;

                    pq.offer(new Node(nextNode, dist[nextNode]));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}