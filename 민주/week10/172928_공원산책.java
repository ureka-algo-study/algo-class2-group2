import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        boolean[][] map = new boolean[park.length][park[0].length()];
        
        int[] cur = new int[2];
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                map[i][j] = park[i].charAt(j) == 'X'? false : true;
                if(park[i].charAt(j) == 'S'){
                    cur[0] = i;
                    cur[1] = j;
                }
            }
            
        }
        
        // System.out.println(Arrays.toString(cur));
        
        for (String route : routes){
            // System.out.println(route);
            StringTokenizer token = new StringTokenizer(route);
            String str = token.nextToken();
            int[] dir = new int[2];
            int num = Integer.parseInt(token.nextToken());
            
            switch(str){
                case "S":
                    dir[0] = 1;
                    dir[1] = 0;
                    break;
                case "N":
                    dir[0] = -1;
                    dir[1] = 0;
                    break;
                case "W":
                    dir[0] = 0;
                    dir[1] = -1;
                    break;
                case "E":
                    dir[0] = 0;
                    dir[1] = 1;
                    break;
            }
            
            int[] next;
            next = cur.clone();
            
            while(num > 0){
                next[0] += dir[0];
                next[1] += dir[1];
                // System.out.print(Arrays.toString(next) + " : ");
                if(next[0] < 0 || next[0] >= map.length || next[1] < 0 || next[1] >= map[0].length){
                    // System.out.println(" : index out");
                    break;
                } 
                if(!map[next[0]][next[1]]) {
                    // System.out.println(" : map break");
                    break;
                }
                
                // System.out.println("success");
                
                // System.out.println(Arrays.toString(next));
                num --;
                
            }
            
            if(num <= 0){
                cur = next.clone();
                // System.out.println(Arrays.toString(cur));
            }
        }
        return cur;
    }
}