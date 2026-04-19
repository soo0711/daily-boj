package programmers_42577_전화번호_목록;

/**
 문제이해
 전화번호부에 적힌 전화번호에 어떤 번호가 다른 번호의 접두어인 경우에 false반환

 제한사항
 phone_book의 길이는 1 이상 1,000,000 이하
 각 전화번호의 길이는 1 이상 20 이하
 같은 전화번호가 중복해서 들어있지 않습니다.

 풀이과정
 "119", "97674223", "1195524421"
 1. for문 뽑아서 길이만큼 잘라서 확인
 2. 같으면 return false
 3. 다르면 반복

 풀이과정 (2)
 1. 정렬을 한다.
 2. 정렬을 하면 앞번호가 같은 번호끼리 붙게된다.
 3. 앞의 단어가 뒤에 단어로 시작하는지 확인한다.
 4. 시작하면 fasle
 5. 아니며 반복

 **/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }

        boolean answer = true;
        return answer;
    }
}
