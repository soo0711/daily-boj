package boj_1269_대칭_차집합;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> interaction = new HashSet<>(setA);
        interaction.retainAll(setB);

        System.out.println(n + m - 2 * (interaction.size()));

        br.close();
    }
}
