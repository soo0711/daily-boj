package programmers_87390_n의_제곱_배열_자르기;

/**
 문제이해
 2차원 배열을 1차원 배열을 만든다.
 1차원 배열을 만든 뒤 left ~ right까지의 배열을 추출해 return.

 제한사항
 1 ≤ n ≤ 107
 0 ≤ left ≤ right < n2
 right - left < 105

 풀이과정
 1. 2차원 배열을 만든다.
 2. 2차원 배열을 채운다.
 3. 1차원 배열을 만든다.
 4. left~right만 자른다.
 -> 시간초과 주의

 어떻게 복잡도를 구현할까.
 1. 규칙을 구해보자
 123 223 333
 012 345 678

 여기서 규칙을 찾아서
 left~right만 뽑아내자

 012 345 678
 3/3 4/3 5/3 = 1 -> 2열
 3%3 4%3 5%3 = 0 1 2 -> 1행, 2행, 3행
 n = 3
 left = 2
 right = 5
 2 3 4 5
 2/3 = 0 + 1 => 2
 2%3 = 2 + 1 => 3
 Math.max(2,3) => 3

 3/3 = 1 +1 => 2
 3%3 = 0 +1 => 2
 Math.max(2,2) => 2

 4/3 = 1 +1 => 2
 4%3 = 1 + 1 => 2

 5/3 => 1 + 1 => 2
 5%3 => 2 + 1 =3
 Math.max(2, 3) => 3

 **/

class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max((int)(left/n) + 1, (int)(left%n) + 1);
            left++;
        }

        return answer;
    }
}
