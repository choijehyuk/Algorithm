import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;
    static ArrayList<Integer> input;
    static int[] time;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        indegree = new int[N + 1];
        input = new ArrayList<>();
        time = new int[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int buildTime = Integer.parseInt(st.nextToken());
            time[i] = buildTime;

            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }

                input.add(num);
            }

            if (input.size() == 0) {
                list.get(i).add(0);
                continue;
            }

            for (int j = 0; j < input.size(); j++) {
                list.get(input.get(j)).add(i);

                indegree[i]++;
            }

            input.clear();
        }

        solve();

        for (int i = 1; i < result.length; i++) {
            System.out.print((result[i] + time[i]) + " ");
        }

    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                indegree[list.get(now).get(i)]--;

                result[list.get(now).get(i)] = Math.max(result[list.get(now).get(i)], result[now] + time[now]);

                if (indegree[list.get(now).get(i)] == 0) {
                    q.add(list.get(now).get(i));
                }
            }
        }
    }
}