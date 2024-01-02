import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1){
                sb.append("1 1\n");
                continue;
            }
            int[] eng = new int[26];

            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                eng[c - 97]++;
            }


            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                if (eng[c - 97] >= K) {
                    int check = 1;

                    for (int j = i + 1; j < W.length(); j++) {
                        if (W.charAt(j) == c) check++;
                        if (check == K) {
                            min = Math.min(min, j - i + 1);
                            max = Math.max(max, j - i + 1);
                            break;
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(min + " " + max + "\n");
            }

        }
        System.out.println(sb);
    }

}