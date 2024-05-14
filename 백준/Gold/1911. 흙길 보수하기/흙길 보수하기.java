import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end));

        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        int answer = 0;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (list.get(i).start > idx) idx = list.get(i).start;
            if (list.get(i).end >= idx) {
                while (list.get(i).end > idx) {
                    idx += L;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}