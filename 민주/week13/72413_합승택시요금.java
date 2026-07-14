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
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] dist = new int[3][n+1];
        int[] start = {s,a,b};
        
        for(int i=0; i<3; i++){
            Arrays.fill(dist[i], 987654321);
        }
        ArrayList<Edge>[] edges = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            edges[c].add(new Edge(d,f));
            edges[d].add(new Edge(c,f));
        }
        
        for(int t=0; t<3; t++){
            boolean[] visited = new boolean[n+1];
            
            dist[t][start[t]] = 0;
            visited[start[t]] = true;
            
            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
            
            for(Edge e : edges[start[t]]){
                pq.offer(e);
            }
            
            while(!pq.isEmpty()){
                Edge cur = pq.poll();
                if(visited[cur.v]) continue;
                visited[cur.v] = true;
                
                dist[t][cur.v] = cur.w;
                
                for(Edge e: edges[cur.v]){
                    pq.offer(new Edge(e.v, e.w + cur.w));
                }
            }
        }
        
//         for(int i=0; i<3; i++){
//             System.out.println(Arrays.toString(dist[i]));
//         }
        
        answer = 987654321;
        
        for(int i=1; i<=n; i++){
            if(dist[0][i] == 987654321 || dist[1][i] == 987654321 || dist[2][i] == 987654321) continue;
            answer = Math.min(answer, dist[0][i] + dist[1][i] + dist[2][i]);
        }
        return answer;
    }
}