import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;
    static int[] input;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        answer = new int[10];
        input = new int[10];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(int depth) {
        if (depth == 10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == input[i]) cnt++;
            }

            if (cnt >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (input[depth - 1] == i && input[depth - 2] == i) {
                    continue;
                }
            }
            input[depth] = i;
            dfs(depth + 1);
        }

    }
}