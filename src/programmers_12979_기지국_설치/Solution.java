package programmers_12979_기지국_설치;

/**
 ### 문제 이해
 전파 거리가 w인 5g 기지국을 모든 아파트에 전파할 수 있는
 최소 설치 개수를 구하여라

 ### 주의 사항
 - 최소 설치
 - N: 200,000,000 이하의 자연수  << 반복문 X
 - stations의 크기: 10,000 이하의 자연수

 ### 풀이과정 1
 1. 처음 장소에 +- w를 해준다.
 2. 그 이후에 -한 곳의 - 장소를 이분탐색을 진행한다.
 3. 이분탐색에 도착한 곳이 전파 도달이 안 된 곳이면
 4. +- w를 해주고 다시 이분탐색을 진행한다.


 ### 풀이과정 2
 1 2 3 4 5 6 7 8 9 (10 11 12) 13 14

 기지국 1개당 자기 자리 + 양쪽 2 * w
 w가 2였을 때 기지국 1개당 땅 5개
 6 / 5 = 1
 6 % 5 = 1
 +2개 (몫 + 나머지)

 16-11 =5
 5 /5 = 1
 5 % 5 = 0
 +1개
 3개


 기지국 1개당 자기 자리 + 양쪽 2 * w
 w = 1
 자리 3개
 기지국 4
 2 / 3 = 0
 2 % 3 = 2
 +  0 -> 1개


 기지국 11
 9 - 마지막 전파 위치
 4 / 3 = 1
 4 % 3 = 1
 2개

 **/

class Solution {

    public int solution(int n, int[] stations, int w) {

        int answer = 0;

        // 기지국 1개당 자기 자리 + 양쪽 2 * w
        int weight = 1 + 2 * w;
        int temp = 0;
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] - w > 0) {
                int num = stations[i] - w - temp - 1;
                if (num > 0) {
                    answer += num / weight;
                    if (num % weight != 0) {
                        answer++;
                    }
                }
            }
            temp = stations[i] + w;
        }

        if (temp < n) {
            int num = n - temp;
            if (num > 0) {
                if (num > 0) {
                    answer += num / weight;
                    if (num % weight != 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
