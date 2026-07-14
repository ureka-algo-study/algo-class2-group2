class Solution {
    int[][] arr;
    int[] answer;
    public int[] solution(int[][] arr) {
        this.arr = arr;
        answer = new int[2];
        quad(0, 0, arr.length);
        
        return answer;
    }
    
    boolean check(int sx, int sy, int n){
        int num = arr[sx][sy];
        for(int i=sx; i<sx+n; i++){
            for(int j=sy; j<sy+n; j++){
                if(num != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    void quad(int sx, int sy, int n){
        if(check(sx, sy, n)){
            answer[ arr[sx][sy] ] += 1;
            return;
        }
        else{
            quad(sx, sy, n/2);
            quad(sx + n/2, sy, n/2);
            quad(sx, sy + n/2, n/2);
            quad(sx + n/2, sy + n/2, n/2);
        }
    }
}