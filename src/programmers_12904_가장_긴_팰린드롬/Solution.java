package programmers_12904_가장_긴_팰린드롬;

/**
 문제이해
 s의 부분 문자열 중 가장 긴 팰린드롬의 길이를 출력해라.
 팰린드롬은 앞뒤를 뒤집어도 똑같은 문자열이다.

 제한사항
 문자열 s의 길이 : 2,500 이하의 자연수
 문자열 s는 알파벳 소문자로만 구성

 풀이과정
 "abcdcba"
 abc d cba -> 7

 "abacde" -> 3
 a b a / cde

 1. idx 1 ~ idx.length 부터 시작해서 왼쪽 오른쪽이 같은지 보기


 풀이과정(2)
 abacde
 edcaba

 **/

import java.util.*;

class Solution
{
    public int solution(String s)
    {

        int answer = 0;
        if (s.length() == 1) {
            return 1;
        }

        // 홀수용
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            int left = i - 1;
            int right = i + 1;
            int mid = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left--) == s.charAt(right++)) {
                cnt++;
            }

            cnt = (cnt * 2) + 1;

            if (answer < cnt) answer = cnt;
        }

        // 짝수인데 다를 경우 "abbacd" "dcabba"
        for (int i = 0; i < s.length() -1; i++) {
            int cnt = 0;
            int left = i - 1;
            int right = i + 2;
            int mid = i;
            if (s.charAt(mid) != s.charAt(mid + 1)) {
                continue;
            }
            while (left >= 0 && right < s.length()
                    && s.charAt(left--) == s.charAt(right++)) {
                cnt++;
            }
            cnt = (cnt * 2) + 2;

            if (answer < cnt) answer = cnt;
        }
        return answer;
    }
}
