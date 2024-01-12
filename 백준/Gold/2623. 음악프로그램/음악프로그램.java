import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        list = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int singer = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < singer - 1; j++) {
                int now = Integer.parseInt(st.nextToken());

                list.get(prev).add(now);
                prev = now;
                indegree[now]++;
            }

        }

        solve();

        if (result.size() != N) {
            System.out.println("0");
            System.exit(0);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            result.add(now);

            for (int i = 0; i < list.get(now).size(); i++) {
                indegree[list.get(now).get(i)]--;

                if (indegree[list.get(now).get(i)] == 0) {
                    q.add(list.get(now).get(i));
                }
            }
        }
    }
}