import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            System.exit(0);
        }
        if (N > 1022) {
            System.out.println(-1);
            System.exit(0);
        }

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            solve(i, 1);
        }
        Collections.sort(list);

        System.out.println(list.get(N));
    }

    private static void solve(long num, int cnt) {
        if (cnt > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            solve(num * 10 + i, cnt + 1);
        }
    }
}