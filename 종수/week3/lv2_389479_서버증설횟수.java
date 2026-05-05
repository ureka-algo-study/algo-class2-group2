package 종수.week3;

class Solution {
    public int solution(int[] players, int m, int k) {

        int answer = 0;
        int n;
        int a[] = new int[24];

        for (int i = 0; i < players.length; i++) {
            
            n = (players[i] / m) - a[i]; // 증설해야 할 서버 수를 구하고
            
            System.out.println("i = " + i + " , n = " + n +" , player = " + players[i] +" , answer = " + answer);
            if (n > 0) { // 증설해야할 서버가 있으면
                answer += n; // 증설횟수 저장하고
                a[i] += n; // 서버의 수를 타임라인에 등록
                if (i + k < 24) { // i + k 가 24를 넘어가면 배열의 범위를 넘어가니까
                    a[i + k] -= n; // 그 이하의 범위에서만 사라질 서버를 --
                } // if
                
            } // if
            if (i + 1 < 24) {// 현재의 서버 수를 다음으로 넘김
                    a[i + 1] += a[i];
                } // if

        } // for
    
        return answer;
    }//solution


}//class

// m - 1 = 증설되지 않았을 때 가능한 최대 이용자 숫자
// n = 증설되야할 서버의 수?
// k = 서버가 살아있는 시간
//
//
//
// 증가하고 사라지는 부분을 어떻게 해야할까...?
//
// n > 1 이상이면 answer++
