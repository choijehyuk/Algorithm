import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int F = Integer.parseInt(br.readLine());

            parents = new int[F * 2];
            depth = new int[F * 2];

            for (int i = 0; i < F * 2; i++) {
                parents[i] = i;
                depth[i] = 1;
            }

            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) map.put(a, idx++);
                if (!map.containsKey(b)) map.put(b, idx++);
                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
            depth[x] += depth[y];

            depth[y] = 1;
        }
        return depth[x];
    }

    private static Integer find(Integer x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}