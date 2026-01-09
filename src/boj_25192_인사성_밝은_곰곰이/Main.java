package boj_25192_인사성_밝은_곰곰이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String record = br.readLine();
            if (record.equals("ENTER")) {
                set.clear();
            } else if (!set.contains(record)) {
                set.add(record);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}


