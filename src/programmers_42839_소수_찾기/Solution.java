package programmers_42839_소수_찾기;

/**
 문제이해
 떨어진 숫자를 붙여서 소수를 몇개 만들 수 있는지를 출력해라

 제한사항
 numbers는 길이 1 이상 7 이하인 문자열
 numbers는 0~9까지 숫자
 "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미

 풀이과정
 1. 배열로 바꾸기
 2. 가능한 숫자 List에 저장
 3. 소수인지 아닌지 판별하는 함수
 4. 소수면 cnt++

 **/
import java.util.*;

class Solution {

    // 가능한 숫자 저장하기
    Set<Integer> set = new HashSet<>();
    boolean[] visit;

    public int solution(String numbers) {

        String[] sNum = numbers.split("");
        visit = new boolean[sNum.length];

        // 모든 경우의 수
        dfs(sNum, "");

        int answer = 0;
        // 소수인지 판별
        for (int n : set) {
            if (n == 1 || n == 0) {
                continue;
            }
            if (isPrime(n)) {
                answer++;
            }
        }


        return answer;
    }

    void dfs(String[] sNum, String n) {

        for (int i = 0; i < sNum.length; i++) {
            if (!visit[i]) {
                String s = n + sNum[i];
                visit[i] = true;
                set.add(Integer.parseInt(s));
                dfs(sNum, s);
                visit[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        double limit = Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
