class Solution {

    class Pointer {
        int value;
        int idx;
        int count;

        public Pointer(int value, int idx, int count) {
            this.value = value;
            this.idx = idx;
            this.count = count;
        }
    }
    public int solution(int[] queue1, int[] queue2) {

        // 두 배열 합치기
        int[] array = new int[queue1.length + queue2.length];
        for(int i = 0; i < queue1.length; i ++) {
            array[i] = queue1[i];
        }
        for(int i = queue1.length; i < array.length; i ++) {
            array[i] = queue2[i - queue1.length];
        }

        // queue1 의 합
        long queue1Sum = 0;
        for(int i = 0; i < queue1.length; i ++) {
            queue1Sum += array[i];
        }

        // 전체합 구해서 target 설정
        long sum = 0;
        for(int i = 0; i < array.length; i ++) {
            sum += (long) array[i];
        }

        if(sum % 2 == 1) {
            return -1;
        }

        long target = sum / 2;

        // pointer 생성
        Pointer fp = new Pointer(array[0], 0, 0); //q1의 맨앞(뺄거)
        Pointer bp = new Pointer(array[queue1.length], queue1.length, 0);
        //q2의 맨앞(넣을거)

        int maxCount = array.length * 2;

        while(fp.count + bp.count <= maxCount) {

            if (queue1Sum == target) {
                return fp.count + bp.count;
            }

            if(queue1Sum > target) {
                queue1Sum -= fp.value;
                fp.idx = (fp.idx + 1) % array.length;
                fp.count++;
                fp.value = array[fp.idx];
            } else {
                queue1Sum += bp.value;
                bp.idx = (bp.idx + 1) % array.length;
                bp.count++;
                bp.value = array[bp.idx];
            }
        }

        return -1;

    }
}

/*
포인터 2개
양쪽끝에서 출발
[sum p1 p2 ] > target -> 포인터조정(더 작은 값을 버림)
[sum p1 p2 ] = target -> break 이동한 횟수 return
p1 idx > p2 idx return -1
*/

