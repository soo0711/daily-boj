package programmers_17687_3차_n진수_게임;

/**
 문제이해
 진법으로 한 숫자씩 말하는 게임을 할 때, 튜브가 지지않도록 말해야할 숫자를 출력하자.

 제한사항
 2 ≦ n ≦ 16
 0 ＜ t ≦ 1000
 2 ≦ m ≦ 100
 1 ≦ p ≦ m
 10~15는 각각 대문자 A~F로 출력

 풀이과정
 1. 먼저 진법으로 바꾸는 함수를 만든다.
 2. 그리고 진법을 배열에 저장한다.
 3. t*m의 사이즈가 넘으면 break
 4. for문 돌리면서 p가 말해야할 숫자를 저장한다.

 **/
import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {

        String number = "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < t * m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        number += sb.toString();

        sb = new StringBuilder();
        for (int i = p - 1; i < t * m; i += m) {
            sb.append(number.charAt(i));
        }

        String answer = sb.toString();
        return answer;
    }
}
