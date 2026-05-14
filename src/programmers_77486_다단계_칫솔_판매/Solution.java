package programmers_77486_다단계_칫솔_판매;

/**
 문제이해
 추천인에게도 10프로를 나눠주는 다단계 칫솔 판매 계산
 칫솔 판매 이익 개당 100원

 제한사항
 enroll의 길이는 1 이상 10,000 이하입니다
 민호 = center는 안나와있음
 seller의 길이는 1 이상 100,000 이하입니다
 seller에는 같은 이름이 중복가능
 이익은 100 원
 이름 10 글자 이내의 영문 알파벳 소문자
 이름을 담은 배열 enroll,
 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열 referral,
 판매량 집계 데이터의 판매원 이름을 나열한 배열 seller,
 판매량 집계 데이터의 판매 수량을 나열한 배열 amount

 풀이과정
 ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
 ["-",      "-",   "mary", "edward", "mary", "mary", "jaimie", "edward"]
 ["young", "john", "tod", "emily", "mary"]
 [12, 4, 2, 5, 10]
 Node 형식
 1. Node로 조직을 연결해준다. Map 초기화.
 2. 그리고 seller와 amount를 연결해서 계산한다.
 3. Map에 각자의 이익을 넣는다.
 4. 배열을 돌아가며 get 해서 넣는다.

 **/

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // 조직도 초기화
        Map<String, String> group = new HashMap<>();
        // 얻는 값
        Map<String, Integer> sum = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            group.put(enroll[i], referral[i]);
            sum.put(enroll[i], 0);
        }

        // 계산
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int price = amount[i] * 100;

            while(!name.equals("-") && price > 0) {
                int temp = price;
                temp = price - price/10;
                sum.replace(name, sum.get(name) + temp);
                price -= temp;
                name = group.get(name);
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sum.get(enroll[i]);
        }

        return answer;
    }
}
