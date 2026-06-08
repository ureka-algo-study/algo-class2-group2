import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        k에서 모든 신호가 퍼지는 시간(다익스트라)
        */

        // 그래프 생성
        List<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<int[]>());
        }
        for(int i = 0; i < times.length; i ++) {
            graph.get(times[i][0]).add(new int[] {times[i][1],times[i][2]});
        }

        boolean[] visited = new boolean[n+1];
        int[] dijk = new int[n+1];
        Arrays.fill(dijk,Integer.MAX_VALUE);


        dijk[k] = 0;
        int[] cur = {k,0}; // k부터 시작
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
        pq.offer(cur);

        while(!pq.isEmpty()) {

            cur = pq.poll();

            if (visited[cur[0]]) {//이미 방문했으면 검사 X
                continue;
            }

            visited[cur[0]] = true; //pq에 의해 방문할수있는 최소거리이니 방문 확정

            for(int[] i : graph.get(cur[0])) {
                if(cur[1] + i[1] < dijk[i[0]] && !visited[i[0]]) {
                    dijk[i[0]] = cur[1] + i[1];
                    pq.offer(new int[]{i[0] ,dijk[i[0]]});
                }
            }//for
        }

        int max = 0;
        for(int i = 1; i < dijk.length; i ++) {
            if(dijk[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max,dijk[i]);
        }
        return max;







    }
}