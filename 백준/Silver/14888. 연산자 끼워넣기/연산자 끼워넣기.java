import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // + - x /
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int num, int depth) {
        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                if (i == 0) dfs(num + arr[depth], depth + 1);
                else if (i == 1) dfs(num - arr[depth], depth + 1);
                else if (i == 2) dfs(num * arr[depth], depth + 1);
                else if (i == 3) dfs(num / arr[depth], depth + 1);

                op[i]++;
            }

        }
    }
}