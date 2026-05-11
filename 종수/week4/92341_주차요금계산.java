package 종수.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // fees {기본시간, 기본요금, 단위시간, 단위요금}
        int[] answer = {};

        int time[] = new int[records.length];
        int carNumber[] = new int[records.length];
        String status[] = new String[records.length];
        int parkingtime[] = new int[records.length];

        int count = 0;

        for (int i = 0; i < records.length; i++) { // 주차한 시간 계산
            String temp[] = records[i].split(" ");
            if (temp[2].equals("IN")) {
                time[count] = Integer.parseInt(temp[0].replace(":", ""));
                carNumber[count] = Integer.parseInt(temp[1]);
                status[count] = temp[2];
                count++;
            } else if (temp[2].equals("OUT")) {
                for (int j = 0; j < count; j++) {
                    if (status[j].equals("IN") && carNumber[j] == Integer.parseInt(temp[1])) {
                        status[j] = "OUT";
                        int intimehour = (time[j] / 100) % 24;
                        int intimemin = (time[j] % 100);
                        int outtime = Integer.parseInt(temp[0].replace(":", ""));
                        int outtimehour = (outtime / 100) % 24;
                        int outtimemin = (outtime % 100);

                        if (outtimemin < intimemin) {
                            outtimemin += 60;
                            outtimehour -= 1;
                        }
                        int resultmin = outtimemin - intimemin;
                        int resulthour = (outtimehour - intimehour) * 60;
                        parkingtime[j] += resulthour + resultmin; // 주차한 시간
                    } // if

                } // for

            } // else if

        } // for

        for (int i = 0; i < count; i++) {
            if (status[i].equals("IN")) {
                status[i] = "OUT";
                int intimehour = (time[i] / 100) % 24;
                int intimemin = (time[i] % 100);
                int outtimehour = (2359 / 100) % 24;
                int outtimemin = (2359 % 100);

                if (outtimemin < intimemin) {
                    outtimemin += 60;
                    outtimehour -= 1;
                }
                int resultmin = outtimemin - intimemin;
                int resulthour = (outtimehour - intimehour) * 60;
                parkingtime[i] += resulthour + resultmin; // 주차한 시간
            }
        }

        int[] sorted = new int[count];

        for (int i = 0; i < count; i++) {
            sorted[i] = carNumber[i];
        }

        Arrays.sort(sorted);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < sorted.length; i++) {

            int total = 0;

            // 같은 차량번호 주차시간 누적
            for (int j = 0; j < carNumber.length; j++) {

                if (sorted[i] == carNumber[j]) {
                    total += parkingtime[j];
                }
            }

            // 이미 계산한 차량번호면 스킵
            boolean check = false;

            for (int j = 0; j < i; j++) {
                if (sorted[i] == sorted[j]) {
                    check = true;
                }
            }

            if (check) {
                continue;
            }

            // 요금 계산
            int fee = fees[1];

            if (total > fees[0]) {

                int extra = total - fees[0];

                int unit = extra / fees[2];

                if (extra % fees[2] != 0) {
                    unit++;
                }

                fee += unit * fees[3];
            }

            list.add(fee);
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }// psvm

}// class
