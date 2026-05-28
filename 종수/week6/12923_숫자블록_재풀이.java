package 종수.week6;

// begin 부터 end 까지 1씩 증가하며 진행. 이때 현재는 now
// now의 값은 제외하고 now의 배수들만 end까지 now의 값으로 초기화
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer;

        int size = (int)(end - begin + 1); // begin과 end사이의 갯수
        answer = new int[size];


        int idx = 0;
        for (long num = begin; num <= end; num++) {
            
            if (num == 1){
                answer[idx++] = 0;
                continue;
            }

            int block = 1;
            for(int j = 2; j * j <= num; j++ ){

                if(num % j == 0){
                    long pair = num /j;

                    if(pair <= 10000000){
                        block = (int)pair;
                        break;
                    }
                }

            }

            answer[idx++] = block;

        }

        return answer;
    }
}

