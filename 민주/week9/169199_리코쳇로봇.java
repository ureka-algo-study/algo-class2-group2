import java.util.*;

class Solution {
    class Node{
        int x;
        int y;
        int depth;
        char dir;
        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    } // class Node
    
    
    public int solution(String[] board) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        int[] di = {-1, 1, 0, 0}; // 상하좌우
        int[] dj = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    q.offer(new Node(i, j, 0));
                }
            }
        } //for i
        
        int test = 0;
        while(!q.isEmpty()){ //test++ < 5
            
            Node cur = q.poll();
            visited[cur.x][cur.y] = true;
            // System.out.println("poll: " + cur.x + ", " + cur.y + ", " + (cur.depth));
            
            if(board[cur.x].charAt(cur.y) == 'G'){
                return cur.depth;
            }
            for(int idx=0; idx<di.length; idx++){
                int i = cur.x;
                int j = cur.y;
                int ni = i + di[idx];
                int nj = j + dj[idx];
                
                while(ni>=0 && ni<board.length && nj>=0 
                      && nj < board[cur.x].length() && board[ni].charAt(nj)!='D'){
                    i = ni;
                    j = nj;
                    
                    ni += di[idx];
                    nj += dj[idx];
                }
                
                if((i != cur.x || j != cur.y) && !visited[i][j]){
                    // System.out.println("offer: " + i + ", " + j + ", " + (cur.depth+1));
                    q.offer(new Node(i, j, cur.depth+1));
                }
                
            }
            
        }
        return -1;
    }
}