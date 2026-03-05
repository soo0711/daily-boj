package programmers_12924_숫자의_표현;

/**
 연속하는 숫자를 조합해서 자연수 n을 만드는 방법의 개수를 출력해라

 어떤알고리즘? => 투포인트, 슬라이딩 윈도우

 초기
 1,2,3,4,5 = 15 cnt++

 반복에 n만 남을 동안
 start와 end만 움직인다.
 15와 같으면 start++; end++;
 값 비교 15보다 크면 start++;만
 값 비교가 15보다 크면 end++;만

 2,3,4,5,6 (20) > 15
 3,4,5,6 (18)
 4,5,6 (15)
 5,6,7 18
 6 7 13 < 15
 6 7 8 > 15


 코드 최적화 => 연속하는 수는 규칙이 있다 n의 홀수의 약수의 개수가 연속되는 수의 개수이기 때문에
 for (int i = 1; i * i <= n; i++) {
 if (n % i == 0) {
 if (i % 2 == 1) answer++;

 int other = n / i;
 if (other != i && other % 2 == 1) answer++;
 }
 }
 **/

class Solution {
    public int solution(int n) {

        // 경우의 수
        int answer = 0;
        // 포인터
        int start = 1;
        int end = 1;
        // 합계
        int sum = 1;

        while (start <= n) {
            if (sum > n) {
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end;
            } else { // 같을 경우
                answer++;

                sum -= start;
                start++;
            }
        }

        return answer;
    }
}
