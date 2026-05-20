package programmers_92341_주차_요금_계산;

/**
 문제이해
 입차, 출차 기록을 보고 주차요금을 계산하여라.

 제한사항
 차량 번호가 작은 자동차부터 청구할 주차 요금
 fees의 길이 = 4 = 기본 시간 / 요금 / 단위 시간 / 요금
 1 ≤ records의 길이 ≤ 1,000
 "시각 차량번호 내역" -> 시각, 차량번호, 내역은 하나의 공백
 HH:MM은 00:00부터 23:59
 records의 원소들은 시각을 기준으로 오름차순으로 정렬

 풀이과정
 [120, 0, 60, 591]
 ["16:00 3961 IN",
 "16:00 0202 IN",
 "18:00 3961 OUT",
 "18:00 0202 OUT",
 "23:58 3961 IN"]
 차량 -> 시간
 시간 저장은 어떻게 할까.
 시작한 시간 / 총합 -> map을 두개로

 1. map을 2개로 만든다.
 2. records for문을 돈다.
 3. 이때 in이면 map1에 분을 계산해서 넣는다.
 4. out일 때 map1에서 꺼내서 map2에 총합을 넣는다.
 5. map1엔 있고 map2에 없는 것들을 23:59로 계산해서 넣는다.
 5. map2를 돌면서 요금을 계산한다.
 6. 차량번호로 정렬한다. -> sort

 **/

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        // 입차 저장, 총시각 저장
        Map<String, Integer> inCar = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (String record : records) {
            // 23:58 3961 IN
            String[] r = record.split(" ");
            int hour = Integer.parseInt(r[0].split(":")[0]) * 60;
            int minute = Integer.parseInt(r[0].split(":")[1]);
            String car = r[1];
            String status = r[2];
            if (status.equals("IN")) {
                inCar.put(car, hour + minute);
            } else {
                int time = (hour + minute) - inCar.get(car);
                total.put(car, total.getOrDefault(car, 0) + time);
                inCar.replace(car, -1);
            }
        }

        // 입차했지만 출차 안 한 차들
        int time = (23 * 60) + 59;
        for (String s : inCar.keySet()) {
            if (inCar.get(s) != -1) {
                int t = time - inCar.get(s);
                total.put(s, total.getOrDefault(s, 0) + t);
            }
        }

        // 요금 계산
        // fee[1] + ⌈(334 - fee[0]) / fee[2]⌉ x fee[3] = 14600
        for (String s : total.keySet()) {
            int num = ((total.get(s) - fees[0]) % fees[2]) == 0 ? 0 : 1;
            int cnt = ((total.get(s) - fees[0]) / fees[2]);
            if ((total.get(s) - fees[0]) < 0) {
                cnt = 0;
                num = 0;
            }
            int sum = fees[1]
                    + (cnt + num) * fees[3];
            total.replace(s, sum);
        }

        // 정렬
        List<String> list = new ArrayList<>(total.keySet());
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = total.get(list.get(i));
        }

        return answer;
    }
}
