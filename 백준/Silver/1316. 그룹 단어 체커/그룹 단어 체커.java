import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int cnt = N;

        for (int i = 0; i < N; i++) {

            String s = br.readLine();

            boolean[] v = new boolean[26];
            v[s.charAt(0) - 97] = true;

            for (int j = 1; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == s.charAt(j - 1)) continue;


                if (v[(int) c - 97]) {
                    cnt--;
                    break;
                }
                v[(int) c - 97] = true;
            }
        }
        System.out.println(cnt);
    }
}