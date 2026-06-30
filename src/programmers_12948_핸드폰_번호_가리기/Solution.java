package programmers_12948_핸드폰_번호_가리기;

/**
 문제이해
 전화번호의 뒷 4자리를 제외한 나머지를 전부 *으로 가린 문자열을 리턴해라

 제한사항
 phone_number는 길이 4 이상, 20이하인 문자열

 풀이과정
 1. 길이를 구한다.
 2. 길이 - 4만큼 *를 저장하고
 3. 그뒤에 길이 4를 붙인다.

 **/
import java.util.*;

class Solution {
    public String solution(String phone_number) {
        int n = phone_number.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 4; i++) {
            sb.append('*');
        }

        for (int i = n - 4; i < n; i++) {
            sb.append(phone_number.charAt(i));
        }
        String answer = sb.toString();
        return answer;
    }
}
