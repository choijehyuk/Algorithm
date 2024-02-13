import java.util.*;
import java.io.*;

public class Main {

    static LinkedList<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (check(arr[i])) {
                while (arr[i] != q.get(0)) {
                    q.addLast(q.pollFirst());
                    answer++;
                }
            } else {
                while (arr[i] != q.get(0)) {
                    q.addFirst(q.pollLast());
                    answer++;
                }
            }
            q.poll();
        }

        System.out.println(answer);
    }

    private static boolean check(int n) {
        for (int i = 0; i <= q.size() / 2; i++) {
            if (n == q.get(i)) return true;
        }
        return false;
    }

}