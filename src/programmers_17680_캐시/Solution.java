package programmers_17680_캐시;

/**
 문제이해
 DB 캐시를 적용할 때 실행시간 return을 구하여라.

 제한사항
 cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30
 cities는 도시 이름으로 이뤄진 문자열 배열
 대 도시 수는 100,000개 -> 시간복잡도 주의
 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성
 대소문자 구분을 하지 않는다
 도시 이름은 최대 20자

 조건
 교체 알고리즘 LRU = 오래된 캐시 삭제 알고리즘
 hit -> 1초
 miss -> 5초

 풀이과정
 1. Node를 클래스를 만든다.
 2. 최근 언제 사용했는지 idx를 넣는다.
 3. map 활용해서 중복방지, cotain으로 hit활용
 4. miss 일 때는 LRU 찾는 함수 불러서 교체
 ["Jeju", "Pangyo", "NewYork", "newyork"]
 **/

import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {

        Map<String, Integer> map = new HashMap<>();

        int total = 0;

        if (cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            city = city.toLowerCase();

            // hit
            if (map.containsKey(city)) {
                map.replace(city, total);
                total++;
                continue;
            }

            // miss
            if (map.size() < cacheSize) {
                map.put(city, total);
                total+=5;
                continue;
            }

            LRU(map, city, cacheSize, total);
            total+=5;
        }

        int answer = total;
        return answer;
    }

    void LRU (Map<String, Integer> map, String city,
              int cacheSize, int total) {

        String min = city;
        for (String key : map.keySet()) {
            if (map.getOrDefault(min, total) > map.get(key)) min = key;
        }

        map.remove(min);
        map.put(city, total);
    }
}
