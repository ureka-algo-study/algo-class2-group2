import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] di = {0,0,-1,1}; //동서남북
        int[] dj = {1,-1,0,0}; 
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    continue;
                }
                if(visited[i][j]) continue;
                
                Queue<int[]> q = new LinkedList<>();
                int sum = Integer.parseInt(maps[i].charAt(j) + "");
                int[] start = {i,j};
                visited[i][j] = true;
                q.offer(start);
                
                while(!q.isEmpty()){
                    int[] pop = q.poll();
                    for(int idx=0; idx<4; idx++){
                        int x = pop[0] + di[idx];
                        int y = pop[1] + dj[idx];
                        
                        if(x>=0 && x<maps.length && y>=0 && y<maps[0].length() 
                           && maps[x].charAt(y) != 'X' && !visited[x][y] ){
                            int[] tmp = {x,y};
                            visited[x][y] =true;
                            sum += Integer.parseInt(maps[x].charAt(y) + "");
                            q.offer(tmp);
                        }
                    }
                } //while
                
                list.add(sum);
                
                
                
            }
        } // for i
        if(list.size() == 0){
            list.add(-1);
        }
        answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        // System.out.println(list.toString());
        return answer;
    }
}