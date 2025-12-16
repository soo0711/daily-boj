package boj_18870_좌표_압축;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] sorted = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            sorted[i] = array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, cnt);
                cnt ++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            sb.append(map.get(array[i]) +" ");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();

    }
}
