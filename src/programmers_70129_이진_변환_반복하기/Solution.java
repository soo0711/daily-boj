package programmers_70129_이진_변환_반복하기;

/**
 1. 1이 될 때까지 반복한다.
 2. 0의 개수를 세서 length에서 뺀다.
 2-1. zero += 0의 개수
 3. 제거한 length를 이진법으로 바꾼다.
 3-1. cnt++;
 **/

class Solution {
    public int[] solution(String s) {

        int zero = 0;
        int cnt = 0;
        while (!s.equals("1")) {

            // 1의 개수 세기
            int next = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    next++;
                }
            }
            zero += s.length() - next;

            // next -> 이진법
            s = Integer.toBinaryString(next);

            // 회차
            cnt++;
        }

        return new int[]{cnt, zero};
    }
}
