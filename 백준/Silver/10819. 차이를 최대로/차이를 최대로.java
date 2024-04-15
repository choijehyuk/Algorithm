import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] nums;
    static boolean[] v;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        v = new boolean[N];
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int sum = calMax();
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                nums[depth] = arr[i];
                dfs(depth + 1);
                v[i] = false;
            }
        }
    }

    private static int calMax() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        return sum;
    }
}