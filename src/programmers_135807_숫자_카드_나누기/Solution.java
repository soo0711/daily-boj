package programmers_135807_숫자_카드_나누기;

/**
 문제이해
 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하여라.
 조건 1.
 철수는 모든 숫자를 나눌 수 있고, 영희는 하나도 나눌 수 없는 양의 정수 a

 조건 2.
 영희는 모든 숫자를 나눌 수 있고, 철수는 하나도 나눌 수 없는 양의 정수 a

 제한사항
 조건을 만족하는 a가 없다면, 0을 return
 1 ≤ arrayA의 길이 = arrayB의 길이 ≤ 500,000
 1 ≤ arrayA의 원소, arrayB의 원소 ≤ 100,000,000
 arrayA와 arrayB에는 중복된 원소가 있음

 풀이과정
 1. 철수와 영희의 최대공약수를 구하자.
 2. 최대공약수가 서로 나눠지는지를 확인
 3. 나눠지면 탈락, 안나눠지면 후보에 넣음
 4. 최대값이면 교체

 **/
import java.util.*;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {


        int a = getGcd(arrayA);
        int b = getGcd(arrayB);

        List<Integer> allGcdA = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                allGcdA.add(i);
                if (i != a / i) {
                    allGcdA.add(a / i);
                }
            }
        }

        List<Integer> allGcdB = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(b); i++) {
            if (b % i == 0) {
                allGcdB.add(i);
                if (i != b / i) {
                    allGcdB.add(b / i);
                }
            }
        }


        int answer = 0;
        // 영희가 나눠지면 X
        for (int l : allGcdA) {
            boolean flag = true;
            for (int B : arrayB) {
                if (B % l == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && answer < l) answer = l;
        }

        // 철수가 나눠지면 X
        for (int l : allGcdB) {
            boolean flag = true;
            for (int A : arrayA) {
                if (A % l == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && answer < l) answer = l;
        }

        if (answer == 1) return 0;

        return answer;
    }

    int getGcd (int[] array) {
        int result = array[0];


        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);

            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
