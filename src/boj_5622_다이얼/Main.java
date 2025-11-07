package boj_5622_다이얼;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tels = br.readLine().split("");
        String[][] num = {{"A","B","C"}, {"D","E","F"},{"G","H","I"},
                {"J","K","L"}, {"M","N","O"}, {"P","Q","R","S"},{"T", "U", "V"}, {"W","X","Y","Z"}};

        int sum = 0;
        for (String tel : tels) {
            for (int i = 0; i < num.length; i++){
                for (int j = 0; j < num[i].length; j++){
                    if (tel.equals(num[i][j])){
                        sum += i+3;
                    }
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}
