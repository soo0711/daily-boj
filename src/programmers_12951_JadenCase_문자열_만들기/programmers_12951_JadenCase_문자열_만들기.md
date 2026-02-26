## 💡 프로그래머스 문제
- 문제 링크: [프로그래머스 12951](https://school.programmers.co.kr/learn/courses/30/lessons/12951)
- 문제 요약: 공백을 기준으로 각 단어의 첫 문자는 대문자, 나머지는 소문자로 변환하는 JadenCase 문자열을 만드는 문제.

## 📌 풀이 방법
1. 문자를 char 배열로 조깬 뒤
2. for문을 돌려 공백을 기준으로 첫글자 여부를 판단했다.
3. flag가 `true`면 대문자로
4. flag가 `false`면 소문자로 변환해 출력했다.


## ✅ 느낀 점
`Character.toUpperCase()`와 `toLowerCase()`는 숫자나 특수문자에 영향을 주지 않는다는 점을 알게 되어
불필요한 ASCII 비교를 하지 않아도 된다는 것을 배웠다.