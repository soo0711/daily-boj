package programmers_42885_구명보트;

/**
 문제이해
 구명보트의 무게 제한과 인원제한을 지켜서
 최소의 구명보트 개수를 구해라

 제한사항
 인원 제한 : 2
 무게 제한 : input
 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
 모두 구출 가능함.

 풀이과정
 오름차순 정렬로 바꾼다.
 50 50 70 80
 인덱스 0 + 3이 100 이상이면 +1
 끝 인덱스 --
 0 + 2 100 이상이면 + 1
 끝 인덱스 --
 0 + 1 100 이하면 + 1
 시작 ++, 끝--
 시작이 끝을 넘으면 끝

 **/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;


        // 오름차순 정렬
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer++;
        }

        return answer;
    }
}
