package boj_2108_통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            sum += array[i];
        }

        Arrays.sort(array);
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            int freqCompare = map.get(o2) - map.get(o1);
            if (freqCompare != 0) return freqCompare;
            return o1 - o2;
        });
        int cntMaxNum = keySet.get(0);
        if (keySet.size() > 1 &&
                map.get(keySet.get(0)).equals(map.get(keySet.get(1)))) {
            cntMaxNum = keySet.get(1);
        }

        sb.append(Math.round(sum / n)).append("\n");
        sb.append(array[n / 2]).append("\n");
        sb.append(cntMaxNum).append("\n");
        sb.append(array[n - 1] - array[0]).append("\n");

        System.out.println(sb);
    }
}
