import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;
    static int[] result;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        indegree = new int[N + 1];
        result = new int[N + 1];
        times = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int work = Integer.parseInt(st.nextToken());

                list.get(i).add(work);
                indegree[work]++;
            }
        }

        solve();

        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < indegree.length; i++) {
            result[i] = times[i];
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                result[list.get(now).get(i)] = Math.max(result[list.get(now).get(i)], result[now] + times[list.get(now).get(i)]);
                indegree[list.get(now).get(i)]--;

                if (indegree[list.get(now).get(i)] == 0) {
                    q.add(list.get(now).get(i));
                }
            }
        }
    }
}