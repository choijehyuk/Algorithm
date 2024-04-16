import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static boolean[] people;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        people = new boolean[51];

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            people[Integer.parseInt(st.nextToken())] = true;
        }

        list = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }

        int prev, cur;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());

            prev = Integer.parseInt(st.nextToken());
            list[i].add(prev);

            for (int j = 1; j < partyPeople; j++) {
                cur = Integer.parseInt(st.nextToken());
                list[i].add(cur);
                union(prev, cur);
                prev = cur;
            }
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i]) people[find(i)] = true;
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (list[i].size() > 0) {
                int p = find(list[i].get(0));
                if (!people[p]) answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) parents[a] = b;
            else parents[b] = a;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) return parents[a] = a;
        else return find(parents[a]);
    }
}