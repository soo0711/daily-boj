package programmers_42746_가장_큰_수;

/**
 문제이해
 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 큰 수를 만들어라.

 제한사항
 numbers의 길이는 1 이상 100,000 이하
 numbers의 원소는 0 이상 1,000 이하
 정답이 너무 클 수 있으니 문자열로 바꾸어 return

 풀이과정
 [3, 30, 34, 5, 9]
 "9534330"

 3, 3, 3, 5, 9
 0  4
 9, 5, 3, 3, 3
 0, 4

 맨 앞 한자리를 비교했을 때 큰 거
 다음 두자리를 비교했을 때 큰거
 다음 n자리를 비교했을 때 큰거
 => 문자열로 만들기

 1. 정렬기준을 만들기
 2. 정렬 하기
 3. 문자열로 만들어 출력하기

 34 30 9 5 3
 3, 4, 3, 0 , 9, 5, 3
 9 5 3 3 3
 4   0
 **/

import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] num = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        if (num[0].equals("0")) {
            return "0";
        }


        StringBuilder sb = new StringBuilder();
        for (String n : num) {
            sb.append(n);
        }

        String answer = sb.toString();
        return answer;
    }
}
