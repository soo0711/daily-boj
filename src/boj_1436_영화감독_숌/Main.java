package boj_1436_영화감독_숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 0;

        while (true) {
            if (String.valueOf(result).contains("666")){
                cnt++;
            }
            if (cnt == n) {
                break;
            }
            result++;
        }

        System.out.println(result);

        br.close();
    }
}
