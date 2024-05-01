import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] eng;
    static String[] words;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // a c i n t 5개는 있어야함

        if (K < 5) {
            System.out.println("0");
            System.exit(0);
        }

        if (K == 26) {
            System.out.println(N);
            System.exit(0);
        }

        eng = new int[26];

        char c = 'a';

        eng['a' - c]++;
        eng['c' - c]++;
        eng['i' - c]++;
        eng['n' - c]++;
        eng['t' - c]++;

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int idx) {
        if (depth == K - 5) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                boolean isRead = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (eng[words[i].charAt(j) - 'a'] == 0) {
                        isRead = false;
                        break;
                    }
                }

                if (isRead) cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (eng[i] == 0) {
                eng[i]++;
                dfs(depth + 1, i);
                eng[i]--;

            }
        }

    }
}