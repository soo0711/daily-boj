package programmers_12909_올바른_괄호;

class Solution {
    boolean solution(String s) {

        boolean answer = true;

        // s char[]로 쪼개기
        char[] arr = s.toCharArray();

        // (이면 ++ ) -- 해서 < 0 이면 false
        int cnt = 0;
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        if (cnt != 0) {
            answer = false;
        }

        return answer;
    }
}
