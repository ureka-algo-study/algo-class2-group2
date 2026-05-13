import java.util.*;

class Solution {
    class Edge{
        int v, w;
        
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<Edge>[] edges = new ArrayList[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        
        for(int i=1; i<N+1; i++){
            edges[i] = new ArrayList<>();
            dist[i] = 987654321;
        }
        
        for(int i=0; i<road.length; i++){
            edges[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edges[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        
        pq.offer(new Edge(1, 0));
        dist[1] = 0;
        // visited[1] = true;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            System.out.println("poll: " + cur.v + " , "+ cur.w);
            int start = cur.v;
            
            if(visited[start]) continue;
            visited[start] = true;
            
            for(Edge e : edges[start]){
                if(!visited[e.v]
                  && dist[e.v] > dist[start] + e.w){
                    dist[e.v] = dist[start] + e.w;
                    pq.offer(new Edge(e.v, dist[e.v]));
                    System.out.println("offer: " + e.v + " , "+ dist[e.v]);
                }
            }
            System.out.println(Arrays.toString(dist));
        }
        
        for(int i=1; i<=N ; i++){
            if(dist[i] <= K) answer++;
        }
        
        

        return answer;
    }
}