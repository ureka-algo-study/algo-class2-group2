package 종수.week8;
import java.util.*;

//친구들아 미안해!!!
class Solution {

    static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<Node>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];

            graph[from].add(new Node(to, cost));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[k] = 0;
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) {
                continue;
            }

            for (Node next : graph[cur.to]) {

                int nextCost = dist[cur.to] + next.cost;

                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}