package programmers_12911_다음_큰_숫자;

/**
 문제 정의
 3가지 조건에 맞는 n의 다음 큰 숫자를 구해라

 제한 사항
 조건 1. 다음 큰 숫자는 n보다 큼
 조건 2. 2진수의 1의 개수가 같음
 조건 3. 1,2를 만족하는 가장 작은 수
 n은 1,000,000 => O(N) 까지 가능

 풀이과정
 1씩 올리고
 1의 개수를 확인하고 비교한다.
 o(n) 이 가능한 이유는
 모든 숫자를 다 보는게 아니고 가능한 숫자까지만 보기때문이다.

 Integer.bitCount(n); 내장함수 사용하면 1의 개수를 알 수 있다.
 **/

class Solution {
    public int solution(int n) {
        int answer = 0;

        int nCount = Integer.bitCount(n);
        int idx = n + 1;

        while(true) {
            if (nCount == Integer.bitCount(idx)) {
                answer = idx;
                break;
            }
            idx++;
        }

        return answer;
    }
}
