package boj_26069_붙임성_좋은_총총이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            if (set.contains(p1)){
                set.add(p2);
            } else if (set.contains(p2)) {
                set.add(p1);
            }
        }

        System.out.println(set.size());
    }
}
