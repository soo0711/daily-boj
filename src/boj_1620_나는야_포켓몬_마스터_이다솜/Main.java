package boj_1620_나는야_포켓몬_마스터_이다솜;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map1.put(name, i + 1);
            map2.put(i + 1, name);
        }

        for (int i = 0; i < m; i++) {
            String value = br.readLine();
            if (Character.isDigit(value.charAt(0))) {
                bw.write(map2.get(Integer.parseInt(value)) + "\n");
            } else {
                bw.write(map1.get(value) + "\n");
            }
        }

        bw.flush();
        br.close();
    }
}
