import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 그래프
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }

        for(int[] node : road) {
            graph.get(node[0]).add(new int[]{node[1], node[2]});
            graph.get(node[1]).add(new int[]{node[0], node[2]});
        }

        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0; // 1에서 출발

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o1[1]);

        pq.offer(new int[] {1,0}); // 현재 마을 현재까지 거리

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            int town = cur[0]; // 꺼낸 정점
            int cost = cur[1]; // 꺼낸 거리

            if(cost > dist[town]) {
                continue;
            }

            for(int[] node : graph.get(town)) {
                int nextTown = node[0];
                int nextCost = node[1];

                int newCost = cost + nextCost;

                if(newCost < dist[nextTown]) {
                    dist[nextTown] = newCost;
                    pq.offer(new int[] {nextTown, newCost});
                }
            }
        }


        int count = 0;

        for(int i = 1; i < dist.length; i ++) {
            if(dist[i] <= K) {
                count++;
            }
        }


        return count;

    }
}