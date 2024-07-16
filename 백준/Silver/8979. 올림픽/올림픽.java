import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int num, gold, silver, bronze, rate;

        Node(int num, int gold, int silver, int bronze, int rate) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }

        public int compareTo(Node o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }

    static int N, K;
    static ArrayList<Node> list;
    static int idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze, 0));
        }

        Collections.sort(list);

        list.get(0).rate = 1;

        for (int i = 1; i < list.size(); i++) {
            int tmp_gold = list.get(i - 1).gold;
            int tmp_silver = list.get(i - 1).silver;
            int tmp_bronze = list.get(i - 1).bronze;
            Node now = list.get(i);
            if (list.get(i).num == K) {
                idx = i;
            }
            if (now.gold == tmp_gold && now.silver == tmp_silver && now.bronze == tmp_bronze) {
                list.get(i).rate = list.get(i - 1).rate;
            } else {
                list.get(i).rate = i + 1;
            }
        }

        System.out.println(list.get(idx).rate);
    }

}