package programmers_12938_최고의_집합;

/**
 문제이해
 최고의 집합을 구하여서 오름차순으로 정렬된 1차원 배열에 출력해라

 제한사항
 최고의 집합은 오름차순으로 정렬된 1차원 배열(list, vector) 로 return
 만약 최고의 집합이 존재하지 않는 경우에 크기가 1인 1차원 배열(list, vector) 에 -1
 자연수의 개수 n은 1 이상 10,000 이하의 자연수
 모든 원소들의 합 s는 1 이상, 100,000,000 이하의 자연수

 풀이과정
 최고의 집합 = 원소의 곱이 최대가 되는 집합
 최대 곱 = 큰 수 * 큰 수
 가운데 수
 9 / 3 -> 3
 6 / 2 -> 3
 3 / 1 -> 3


 8 / 3 -> 2 + 1
 5 / 2 -> 2 + 1
 2 / 1 -> 2
 8 -> 2 3 3
 **/

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        int[] answer = new int[n];

        if (n == 1) {
            return new int [] {s};
        }

        if (s / n == 0) {
            return new int [] {-1};
        }

        while (n != 0) {
            int num = s / n;
            int remain = (s % n != 0)? 1 : 0;
            int setN = num + remain;
            s -= (setN);
            answer[n - 1] = setN;
            n--;
        }

        return answer;
    }
}
