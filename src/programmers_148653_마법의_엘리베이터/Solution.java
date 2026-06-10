package programmers_148653_마법의_엘리베이터;

/**
 문제이해
 민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데
 필요한 마법의 돌의 최소개수를 구하여라.

 제한사항
 1 ≤ storey ≤ 100,000,000

 풀이과정
 시간복잡도를 주의해야겠다.
 2554에서 54를 확인 %10 = 4 < 5 -> -4
 2550 -> 255 % 10 = 5 = 5 -> + 5 -> 260
 260 -> 26 % 10 = 6 > 5 + 4 = 30
 30 -> 3
 4 + 5 + 4 + 3 = 16
 1. 마지막이 0이면 / 10 으로 없앤다.
 2. 없앤 후 % 10
 3. 나머지가 5보다 작으면 -k
 4. 5보다 크거나 같으면 + k
 5. answer += k 후에 다시 1번 반복
 6. /10 = 0 이면 끝


 **/
class Solution {
    public int solution(int storey) {

        int answer = 0;

        while (storey > 0) {
            int num = storey % 10;
            int nextNum = (storey / 10) % 10;

            if (num < 5) {
                answer += num;
            } else if (num > 5) {
                answer += (10 - num);
                storey += 10;
            } else {
                answer += 5;

                if (nextNum >= 5) {
                    storey += 10;
                }
            }
            storey /= 10;
        }


        return answer;
    }
}
