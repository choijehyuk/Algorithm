import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;
    static int[] result;
    static int[] D;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N + 1];
            list = new ArrayList<>();
            result = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                list.get(X).add(Y);
                indegree[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            solve();
            sb.append(result[W]).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < indegree.length; i++) {
            result[i] = D[i];
            if (indegree[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                result[list.get(now).get(i)] = Math.max(result[list.get(now).get(i)], result[now] + D[list.get(now).get(i)]);
                indegree[list.get(now).get(i)]--;

                if (indegree[list.get(now).get(i)] == 0) {
                    pq.add(list.get(now).get(i));
                }
            }
        }
    }
}