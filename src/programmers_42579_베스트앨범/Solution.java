package programmers_42579_베스트앨범;

/**
 문제이해
 베스트 앨범을 출시하기 위해 고유번호를 순서대로 출력

 제한사항
 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하
 장르 종류는 100개 미만
 장르에 속한 곡이 하나라면, 하나의 곡만 선택
 모든 장르는 재생된 횟수가 다릅니다
 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

 풀이과정
 1. 먼저 장르별로 재생횟수를 더한다. -> map으로 진행
 2. value로 정렬
 3. play로 정렬

 **/
import java.util.*;

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {

        List<Play> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i],
                    map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Play(genres[i], i, plays[i]));
        }

        // 정렬
        List<String> key = new ArrayList<>(map.keySet());
        Collections.sort(key, (a,b) -> map.get(b) - map.get(a));
        Collections.sort(list);

        // 수록곡 넣기
        List<Integer> album = new ArrayList<>();
        for (String k : key) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                Play p = list.get(i);

                if (p.genre.equals(k)) {
                    album.add(p.num);
                    cnt++;
                }
                if (cnt == 2) {
                    break;
                }
            }
        }

        int[] answer = new int[album.size()];
        for (int i = 0; i < album.size(); i++) {
            answer[i] = album.get(i);
        }

        return answer;
    }

    class Play implements Comparable<Play>{
        String genre;
        int num;
        int cnt;

        Play(String genre, int num, int cnt) {
            this.genre = genre;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Play p) {
            if (this.genre.equals(p.genre)) {
                if (this.cnt == p.cnt) {
                    return this.num - p.num;
                }
                return p.cnt - this.cnt;
            }
            return map.get(p.genre) - map.get(this.genre);
        }
    }
}
