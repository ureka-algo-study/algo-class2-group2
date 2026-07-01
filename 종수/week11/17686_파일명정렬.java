package 종수.week11;

import java.util.Arrays;

class Solution {

    public String[] solution(String[] files) {

        Arrays.sort(files, (a, b) -> {

            // a 분리
            int idxA = 0;
            // isDigit() -> 문자가 숫자인지 확인하는 함수
            // a = false, 1 = true
            while (!Character.isDigit(a.charAt(idxA))) {
                idxA++;
            }

            // head는 0번부터 idxA번까지
            String headA = a.substring(0, idxA);


            int startA = idxA;
            // 숫자 길이 확인
            while (idxA < a.length()
                    && Character.isDigit(a.charAt(idxA))
                    && idxA - startA < 5) {
                idxA++;
            }

            // 넘버 확인
            int numberA = Integer.parseInt(a.substring(startA, idxA));

            // b 분리
            int idxB = 0;
            while (!Character.isDigit(b.charAt(idxB))) {
                idxB++;
            }

            String headB = b.substring(0, idxB);

            int startB = idxB;
            while (idxB < b.length()
                    && Character.isDigit(b.charAt(idxB))
                    && idxB - startB < 5) {
                idxB++;
            }

            int numberB = Integer.parseInt(b.substring(startB, idxB));

            // HEAD 비교
            // compareToIgnoreCase 대소문자 무시하고 비교하는 함수
            // A의 헤드와 B의 헤드를 비교
            int result = headA.compareToIgnoreCase(headB);

            // 헤드가 다르면 순서 그대로 반영
            if (result != 0) {
                return result;
            }

            // 헤드가 같으면 Int로 변환해서
            // NUMBER 비교
            return Integer.compare(numberA, numberB);
        });

        return files;
    }
}

// 정규식 풀이
// class Solution {

//     public String[] solution(String[] files) {

//         Pattern pattern = Pattern.compile("^(.*?)(\\d{1,5})(.*)$");

//         Arrays.sort(files, (a, b) -> {

//             Matcher ma = pattern.matcher(a);
//             Matcher mb = pattern.matcher(b);

//             ma.find();
//             mb.find();

//             String headA = ma.group(1);
//             String headB = mb.group(1);

//             int numberA = Integer.parseInt(ma.group(2));
//             int numberB = Integer.parseInt(mb.group(2));

//             int headCompare = headA.compareToIgnoreCase(headB);

//             if (headCompare != 0) {
//                 return headCompare;
//             }

//             return Integer.compare(numberA, numberB);
//         });

//         return files;
//     }
// }
