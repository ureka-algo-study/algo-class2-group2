import java.util.*;

class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int t=0; t<places.length; t++){
            char[][] place = new char[5][5];
            
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    place[i][j] = places[t][i].charAt(j);
                }
            }
            
            answer[t] = waitPlace(place);
        }
        
        
        return answer;
    }
    
    int waitPlace(char[][] place){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i][j] != 'P') continue;
                if(!isSafe(i, j, place)){
                    return 0;
                }
            }
        }
        return 1;
    }
    
    boolean isSafe (int x, int y, char[][] place){
        for(int i=x-1; i<= x+1; i++){
            for(int j=y-1; j<= y+1; j++){
                if(i < 0 || i >= 5 || j < 0 || j >= 5) continue;
                if(i==x && j == y) continue;
                
                if(place[i][j] == 'P'){
                    if(i == x || j == y){
                        return false;
                    }
                    else if(place[i][y] == 'O' || place[x][j] == 'O')
                        return false;
                }
            }
        } // for
        
        int[][] distance = {
            {2,0},
            {-2,0},
            {0,2},
            {0,-2}
        };
        
        for(int[] dis: distance){
            int nx = x + dis[0];
            int ny = y + dis[1];
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if(place[nx][ny] == 'P'){
                    int midx = (nx + x) / 2;
                    int midy = (ny + y) / 2;
                    
                    if(place[midx][midy] == 'O')
                        return false;
                }
        }
        
        return true;
    }
}