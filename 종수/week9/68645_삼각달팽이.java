package 종수.week9;

class Solution {
    public int[] solution(int n) {

        int triangle[][] = new int[n][];
        for(int i = 0; i < n; i++){
            triangle[i] = new int[i + 1];
        }

        int a = 1;
        int x = 0,y = -1;
        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(i % 3 == 0){
                    y++;
                }
                else if(i % 3 == 1){
                    x++;
                }
                else{
                    x--;
                    y--;
                }

                triangle[y][x] = a++;
                // System.out.println("triangle"+ y+ ","+ x + "입력갑: " + triangle[y][x]);
            }
        }

        int answer[] = new int[a-1];
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){

                answer[idx++] = triangle[i][j];

            }
        }



        return answer;
    }
}