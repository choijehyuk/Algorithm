import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static boolean[] v;
    static boolean[] match;
    static int[] choice;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            choice = new int[N + 1];
            v = new boolean[N + 1];
            match = new boolean[N + 1];
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!match[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - cnt);

        }
    }

    private static void dfs(int depth) {
        if (match[depth]) return;

        if (v[depth]) {
            match[depth] = true;
            cnt++;
        }
        v[depth] = true;
        dfs(choice[depth]);
        match[depth] = true;
        v[depth] = false;
    }

}