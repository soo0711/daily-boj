package programmers_12985_예상_대진표;

/**
 풀이과정
 A번 참가자와 B번 참가자가 몇번째 라운드에 만나지는 출력해라.

 제한사항
 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이김
 N : 2^1 이상 2^20 이하인 자연수
 A, B:  N이하의 자연수

 풀이과정
 1라운드
 0. 먼저 a와 b와 붙는지 확인되면 cnt++ 후 return
 1. A가 짝수면 a-1 vs a, 홀수면 a, a + 1
 2. B가 짝수면 b-1 vs b, 홀수면 b, b + 1
 3. A와 B 숫자 갱신, cnt++
 어떻게? 짝수면 4/2 -> 2번 홀수면 7/2 -> 3 + 1 = 4번
 다시 1,2 반복
 1, 2 // 3, 4
 2/2 -> 1
 4/2 -> 2
 b + 1 == b
 a - 1 == a
 return cnt
 **/

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (a != b) {
            // 갱신
            a = a/2 + a%2;
            b = b/2 + b%2;

            answer++;
        }

        return answer;
    }
}
