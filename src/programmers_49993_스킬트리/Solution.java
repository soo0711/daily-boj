package programmers_49993_스킬트리;

/**
 문제이해
 주어진 스킬을 배울 수 있는 스킬트리인지 출력해라.

 제한사항
 스킬은 알파벳 대문자
 스킬 순서와 스킬트리는 문자열로 표기
 skill의 길이는 1 이상 26
 스킬은 중복해 주어지지 않습니다
 skill_trees는 길이 1 이상 20 이하인 배열
 skill_trees의 원소는 스킬을 나타내는 문자열

 풀이과정
 "CBD"
 "BACDE", "CBADF", "AECB", "BDA"
 1. 순서가 중요함
 2. CBD 외의 단어는 지우기
 3. 순서가 맞는지 확인 -> 하나라도 틀리면 false
 **/

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {

        int sum = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            // CBD 외엔 지우기
            String s = remove(skill, skill_trees[i]);

            // 순서가 맞는지 확인
            if (skill.startsWith(s)) {
                sum++;
            }
        }

        int answer = sum;
        return answer;
    }

    String remove(String skill, String trees) {
        String result = "";

        for (String tree : trees.split("")) {
            if (skill.contains(tree)) {
                result += tree;
            }
        }
        return result;
    }
}
