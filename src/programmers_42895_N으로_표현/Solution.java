package programmers_42895_N으로_표현;

/**
 문제이해
 n과 사칙연산을 써서 number을 만들어라.
 단, n을 최소의 개수만 써서 number을 만들어라.

 제한사항
 N은 1 이상 9 이하입니다.
 number는 1 이상 32,000 이하입니다.
 괄호, 사칙연산, 나누기는 나머지 무시
 최솟값이 8보다 크면 -1을 return 합니다.

 풀이과정1
 사칙연산
 +, -, *, /

 할 수 있는 계산
 5/5
 5+5
 55-5
 55+5
 55/5
 5*5
 55*5

 12 = ? + ? + ? ..
 최소를 구해야함
 하나만 썼을 때
 5 선택지
 0
 5, +5 , -5, *5, /5
 5, +5 , -5, *5, /5

 각각 선택했을 때
 55/ 10 / 0 / 25 / 1
 총을 구해볼까
 재귀로 완전

 풀이과정2
 1. 1개 사용, 2개 사용, 3개 사용 바구니를 만든다.
 2. 3개 사용 = 2개 사용 + 1개 사용, 1개 사용 + 2개 사용
 3. 먼저 개수 바구니를 만들고 N, NN, NNN.. 을 넣어준다.
 4. 그다음 1 ~ 8의 바구니를 돌린다.
 5. 3을 예시로하면
 i가 3이면 1바구니의 값 + 2바구니의 값// 2바구니의 값 + 1 바구니의 값이이 돌아가면서
 들어간다. -> 이때 연산자 +, -, *, /값을 넣어준다.
 4. 그 후 바구니 안에 number가 있으면 i를 넘기고 끝낸다.
 **/

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;

        // 바구니를 만들어준다.
        Set<Integer>[] sets = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            sets[i] = new HashSet<>();
        }

        // 초기 값을 넣어준다.
        int temp = 0;
        for (int i = 1; i < 9; i++) {
            temp = temp * 10 + N;
            sets[i].add(temp);
        }

        // 연산 시작
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : sets[j]) {
                    for (int b : sets[i - j]) {
                        sets[i].add(a + b);
                        sets[i].add(a - b);
                        sets[i].add(a * b);
                        if (b != 0) sets[i].add(a / b);
                    }
                }
            }
            if (sets[i].contains(number)) {
                return i;
            }
        }

        return answer;
    }
}
