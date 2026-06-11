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
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        ArrayList<Edge>[] edges = new ArrayList[n+1];
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
            dist[i] = 987654321;
        }
        
        for(int i=0; i<edge.length; i++){
            edges[edge[i][0]].add(new Edge(edge[i][1], 1));
            edges[edge[i][1]].add(new Edge(edge[i][0], 1));
        }
        
        dist[1] = 0;
        visited[1] = true;
        for(Edge e : edges[1]){
            pq.offer(e);
        }
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(visited[cur.v]) continue;
            visited[cur.v] = true;
            dist[cur.v] = cur.w;
            
            for(Edge e:edges[cur.v]){
                pq.offer(new Edge(e.v, e.w + cur.w));
            }
        }
        
        int max = 0;
        
        for(int i=1; i<=n; i++){
            max = Math.max(max, dist[i]);
        }
        
        
        for(int i=1; i<=n; i++){
            if(dist[i] != max) continue;
            answer++;
        }
        
        // int max = Arrays.stream(dist).boxed().max().getAsInt();
        // System.out.println(max);
        return answer;
    }
}