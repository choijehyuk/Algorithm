import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Node> list = new ArrayList<>();
            int[] cnt = new int[1000001];
            Node[] num = new Node[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
                cnt[x]++;
            }

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.r != o2.r) {
                        return Integer.compare(o1.r, o2.r);
                    } else {
                        return Integer.compare(o1.c, o2.c);
                    }
                }
            });

            int prev = 0;
            for (int i = 0; i < list.size(); ) {
                int start = i, end = i + cnt[list.get(i).r] - 1;

                if (prev == list.get(i).c) {
                    for (int j = start; j <= end; j++) {
                        num[i++] = list.get(j);
                    }
                    prev = list.get(end).c;
                } else {
                    for (int j = end; j >= start; j--) {
                        num[i++] = list.get(j);
                    }
                    prev = list.get(start).c;
                }
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                int input = Integer.parseInt(st.nextToken());
                sb.append(num[input - 1].r + " " + num[input - 1].c).append("\n");
            }

        }
        System.out.println(sb);
    }

}