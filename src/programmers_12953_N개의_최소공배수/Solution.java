package programmers_12953_N개의_최소공배수;

/**
 문제풀이
 n개의 숫자의 최소공배수를 구해라.

 제한사항
 arr은 길이 1이상, 15이하인 배열
 arr의 원소는 100 이하인 자연수

 풀이과정
 최소공약수를 구한뒤
 최소공약수와 나눈 나머지를 곱하면
 최대공배수가 나온다.
 1. 최대공약수를 구한다.
 2. 최대공약수와 나눈 몫을 곱한다.
 3. return
 **/

import java.util.*;

class Solution {

    public int solution(int[] arr) {

        int answer = arr[0];


        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }


    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
