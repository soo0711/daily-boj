package programmers_76502_괄호_회전하기;

/**
 문제이해
 문자를 왼쪽으로 이동시켰을 때 올바른 문자열의 개수를 구하여라.

 제한사항
 s의 길이는 1 이상 1,000 이하입니다.

 풀이과정
 1. 올바른 괄호 문자열인지 검증하는 함수를 만든다.
 2. 올바른 괄호 문자열인지 검증 후 왼쪽으로 이동. 01234 -> 12340 .. -> 23401
 string으로 반환 -> 문자열을 검증한다.

 **/
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // 글자 왼쪽으로 옮기기
            for (int j = 0; j < n; j++) {
                sb.append(s.charAt((i+j)%n));
            }

            // 검사
            if(isCorrect(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }

    boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c ==')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c =='}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c ==']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }

        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
