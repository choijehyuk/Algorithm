import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer> list;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int sum) {
        if (list.size() < 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int num = list.get(i);
            list.remove(i);
            dfs(sum + list.get(i - 1) * list.get(i));
            list.add(i, num);
        }
    }
}