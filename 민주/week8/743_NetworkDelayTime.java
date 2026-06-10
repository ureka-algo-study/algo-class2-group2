import java.util.*;

class Solution {
    class Edge{
        int v;
        int w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)-> a.w - b.w);
        ArrayList<Edge>[] edges = new ArrayList[n+1];
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<times.length; i++){
            edges[times[i][0]].add(new Edge(times[i][1], times[i][2]));
        }

        
        Arrays.fill(dist, 987654321);

        visited[k] = true;
        dist[k] = 0;

        for(Edge e : edges[k]){
            pq.offer(e);
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(visited[cur.v]) continue;
            visited[cur.v] = true;

            dist[cur.v] = cur.w;

            for(Edge e : edges[cur.v]){
                pq.offer(new Edge(e.v, e.w + cur.w));
            }
        }
        
        int answer = 0;
        for(int i=1; i<dist.length; i++){
            answer = Math.max(answer, dist[i]);
        }
        
        if(answer == 987654321){
            return -1;
        }

        // System.out.println(Arrays.toString(dist));
        return answer ;
    }
}