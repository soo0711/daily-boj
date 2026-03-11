package programmers_43165_타겟_넘버;

/**
 문제이해
 순서를 바꾸지 말고 +,-를 사용해서 타겟 넘버로 만들 수 있는 경우의 수를 찾아라

 주의사항
 순서 바꾸지않기

 풀이과정
 1. number가 할 수 있는 경우의 수 +, -
 2. number가 방문해서 +로 할 지, -로 할 지 정한다.
 3. sum = 0
 4. 경우의 수
 **/

class Solution {

    int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public void dfs (int[] numbers, int target, int depth, int sum) {
        if (numbers.length == depth) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
