import java.util.*;
class Solution {


    public String[] solution(String[] orders, int[] course) {List<String> result = new ArrayList<>();


        // 1. 스카피가 원하는 course 만큼 반복
        // 2. 각각의 orders에서 comb로 메뉴 뽑기
        // 3. 뽑은 메뉴 hashMap에 key : value 로 넣기
        // 3-1 hashMap 정렬 내림차순?
        // 4. 가장 많이 나온 메뉴가 2 이상일 경우 코스에 추가
        // 4-1. 동점일 경우 모두 추가
        //

        for(int i = 0; i < course.length; i ++) { //3
            int courseNum = course[i]; // 찾아야할 코스의 가지수
            Map<String,Integer> map = new HashMap<>();
            for(int j = 0; j < orders.length; j ++) {
                // courseNum 만큼 메뉴 수 뽑기
                String order = orders[j]; // 현재 메뉴

                if(order.length() < courseNum) {
                    continue;
                } // 뽑아야하는것보다 적으면 패스

                // 메뉴를 오름차순 정렬
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                order =String.valueOf(arr);




                comb(0,0,courseNum,order,new StringBuilder() ,map); // order에서 courseNum개 메뉴 뽑고 hashMap에 넣기
            } //j
            int max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                if(value > max) {
                    max = value;
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();

                if (count == max && count >= 2) {
                    result.add(key);
                }
            }
        } //i

        // result를 오름차순으로 정렬하고 배열로 변환
        String[] rresult = result.stream().sorted().toArray(String[]::new);
        return rresult;

    }

    private static void comb(int start, int depth, int r, String order,StringBuilder output,Map<String,Integer> map) {

        if(depth == r) {
            String key = output.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for(int i = start; i < order.length(); i ++) {
            output.append(order.charAt(i));
            comb(i + 1, depth + 1, r, order,output,map);
            output.deleteCharAt(output.length() - 1);
        }


    }
}

// 1. 스카피가 원하는 course 만큼 반복
// 2. 각각의 orders에서 comb로 메뉴 뽑기
// 3. 뽑은 메뉴 hashMap에 key : value 로 넣기
// 3-1 hashMap 정렬 내림차순?
// 4. 가장 많이 나온 메뉴가 2 이상일 경우 코스에 추가
// 4-1. 동점일 경우 모두 추가
//