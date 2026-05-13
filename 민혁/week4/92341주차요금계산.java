import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량이 두 번이상 입출차 할 수 있음, 입차한 차량이 안나갈 수 있음
        // 입력값 슬라이싱해서 사용?
        // In이 나오면 set에 넣기 + map에 최신화 하기 / Out이 나오면 set에서 꺼내서 주차요금 구하기 + map 최신화하기
        // 마지막으로 set에 남은 차는 출차를 안한 차로 간주 map에 주차요금 최신화하기
        // map은 treeMap set은 hashSet


        Map<Integer,Integer> inMap = new TreeMap<>();
        Map<Integer,Integer> totalMap = new TreeMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < records.length; i ++) {
            String record = records[i];
            int[] parsed = parsing(record); //[334,5961,0] 형태로 parsing 해서 전달
            if(parsed[2] == 0) {
                //In이 나오면 inMap에 넣기 // totalMap 최신화
                inMap.put(parsed[1], parsed[0]);
                totalMap.put(parsed[1],totalMap.getOrDefault(parsed[1],0)); // 누적시간 유지

            } else {
                //Out이 나오면 inMap에서 꺼내서 주차요금 구하기 + totalMap 최신화
                int accTime = parsed[0] - inMap.get(parsed[1]); // out 이 나오면 누적시간
                totalMap.put(parsed[1],totalMap.get(parsed[1]) + accTime);
                inMap.remove(parsed[1]);
            }
        }

        //출차하지 않은 차들 정리
        int endTime = 23 * 60 + 59;
        for(int key : inMap.keySet()) {
            int accTime = endTime - inMap.get(key);
            totalMap.put(key,totalMap.get(key) + accTime);
        }

        for(int key : totalMap.keySet()) {
            int fee = cal(totalMap.get(key),fees);
            list.add(fee); // 구한 요금을 list로 전달
        }

        // list를 int 배열로 변환
        return list.stream().mapToInt(i->i).toArray();



    }

    static int cal(int time,int[] fees) {
        // 요금 구하는 로직 작성
        // 기본 시간 이하일 경우
        if(time <= fees[0]) {
            return fees[1];
        }
        // 기본 시간 이상일 경우
        if((time - fees[0]) % fees[2] == 0) { // 나머지가 없을 경우
            return fees[1] + (time - fees[0]) / fees[2] * fees[3];
        } else { // 나머지가 있을 때 올림
            return fees[1] + (time - fees[0]) / fees[2] * fees[3] + fees[3];
        }

    }

    static int[] parsing(String record) {
        String[] r = record.split(" ");
        int time = Integer.valueOf(r[0].substring(0,2)) * 60 + Integer.parseInt(r[0].substring(3,5));
        int number = Integer.valueOf(r[1]);
        int entryExit = r[2].equals("IN") ? 0 : 1;
        return new int[] {time, number, entryExit};
    }
}