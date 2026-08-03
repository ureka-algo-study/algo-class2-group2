import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        int idx = 0;
        for(int[] query : queries){
            int sx = query[0]-1;
            int sy = query[1]-1;
            int ex = query[2]-1;
            int ey = query[3]-1;
            
            int nx = sx;
            int ny = sy;
            
            int tmp = arr[sx][sy];
            int min = arr[sx][sy];
            
            while(nx < ex){
                min = Math.min(min, arr[nx][sy]);
                arr[nx][sy] = arr[++nx][sy];
            }
            
            while(ny < ey){
                min = Math.min(min, arr[ex][ny]);
                arr[ex][ny] = arr[ex][++ny];
            }
            
            nx = ex;
            while(nx > sx){
                min = Math.min(min, arr[nx][ey]);
                arr[nx][ey] = arr[--nx][ey];
            }
            ny = ey;
            while(ny > sy){
                min = Math.min(min, arr[sx][ny]);
                arr[sx][ny] = arr[sx][--ny];
            }
            
            if(sy < arr[0].length){
                arr[sx][sy+1] = tmp;
            }
            
            answer[idx++] = min;
            // for(int i=0; i<arr.length; i++){
            //     System.out.println(Arrays.toString(arr[i]));
            // }
            // System.out.println("===================================");
            
        }
        
        
        return answer;
    }
}