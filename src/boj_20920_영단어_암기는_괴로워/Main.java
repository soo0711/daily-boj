package boj_20920_영단어_암기는_괴로워;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> {
            int freqCompare = map.get(o2) - map.get(o1);
            int lengthCompare = o2.length() - o1.length();

            if (freqCompare != 0) {
                return freqCompare;
            }

            if (lengthCompare != 0){
                return lengthCompare;
            }

            return o1.compareTo(o2);
        }));

        for (String s : keySet) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
