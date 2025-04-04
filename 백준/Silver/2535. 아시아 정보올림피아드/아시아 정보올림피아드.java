import java.io.*;
import java.util.*;

class Main {
    public static class Node {
        int country, number, score;

        public Node(int country, int number, int score) {
            this.country = country;
            this.number = number;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        int[] arr = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.score - o1.score;
            }
        });

        int count = 0;
        int print = 0;
        while (print < 3) {
            int countryNum = nodes[count].country;
            arr[countryNum]++;

            if (arr[countryNum] < 3) {
                sb.append(nodes[count].country).append(" ").append(nodes[count].number).append("\n");
                print++;
            }
            count++;
        }

        System.out.println(sb);
    }

}
