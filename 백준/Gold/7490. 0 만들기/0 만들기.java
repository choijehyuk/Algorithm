import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            dfs(N, 1, 1, 1, 0, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n, int cur, int num, int sign, int sum, String s) {
        if (cur == n) {
            sum = sum + num * sign;

            if (sum == 0) {
                sb.append(s).append("\n");
            }
            return;
        }

        dfs(n, cur + 1, num * 10 + (cur + 1), sign, sum, s + " " + String.valueOf(cur + 1));
        dfs(n, cur + 1, cur + 1, 1, sum + (num * sign), s + "+" + String.valueOf(cur + 1));
        dfs(n, cur + 1, cur + 1, -1, sum + (num * sign), s + "-" + String.valueOf(cur + 1));

    }
}