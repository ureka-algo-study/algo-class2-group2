import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
        1. 목적지까지(s -> a, s -> b) 각자 따로 가는 경우
        2. t(특정노드)까지 같이가고 t에서 갈라지는 경우 (s -> t -> a, s -> t -> b)
        */

        // graph 만들기
        // dijk(s에서출발하는)
        // int min = (s -> a + s-> b)
        // t설정 (t = 1 t <= n t ++) {
        // int st = s -> t
        // dijk(t에서 출발하는)
        // int ta = t -> a
        // int tb = t -> b
        // int total = st + ta + tb
        // min = Math.min(min, total) }
        // return min

        // 그래프 만들기
        List<List<int[]>> graph = graph(fares, n);

//         // 1번 경우(각자갈길)
//         int[] fromS = dijk(s, graph, fares, n);
//         int sa = fromS[a]; // s -> a
//         int sb = fromS[b]; // s -> b
//         int min = sa + sb;

//         // 2번 경우(어딘가에서 갈라지기)
//         for(int t = 1; t <= n; t ++) {

//             int[] fromT = dijk(t, graph, fares, n);
//             int st = fromS[t]; // s -> t
//             int ta = fromT[a]; // t -> a
//             int tb = fromT[b]; // t -> b
//             int stab = st + ta + tb;
//             min = Math.min(min, stab);
//         }

        // 어딘가까지는 같이 간다 거기를 t라 하자
        int[] fromS = dijk(s, graph, fares, n);
        int[] fromA = dijk(a, graph, fares, n);
        int[] fromB = dijk(b, graph, fares, n);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < fromS.length; i ++) {
            int total = fromS[i] + fromA[i] + fromB[i];
            min = Math.min(min, total);
        }

        return min;


    }//solution

    public static List<List<int[]>> graph(int[][] fares, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<int[]>());
        }

        for(int[] fare : fares) {
            graph.get(fare[0]).add(new int[] {fare[1],fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0],fare[2]});
        }

        return graph;
    } //graph

    public static int[] dijk(int start, List<List<int[]>> graph, int[][] fares, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 123456789);
        dist[start] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>( (i1, i2) -> i1[1] - i2[1] );
        q.offer(new int[] {start,0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (dist[curNode] < curDist) {
                continue;
            } // 예전 정보 삭제


            for(int[] node : graph.get(curNode)) {
                int nextNode = node[0];
                int nextDist = node[1];

                if(curDist + nextDist < dist[nextNode]) {
                    dist[nextNode] = curDist + nextDist;
                    q.offer(new int[] {nextNode, curDist + nextDist});
                }
            }
        }
        return dist;
    }


}