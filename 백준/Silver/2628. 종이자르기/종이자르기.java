import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int line = Integer.parseInt(br.readLine());
        List<Integer> garo = new ArrayList<>();
        List<Integer> sero = new ArrayList<>();
        garo.add(0);
        sero.add(0);
        garo.add(n);
        sero.add(m);

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (dir == 1) {
                garo.add(num);
            } else if (dir == 0) {
                sero.add(num);
            }
        }

        Collections.sort(garo);
        Collections.sort(sero);

        // 0 4 10 garo n
        // 0 2 3 8 sero  m

        // [0,0] [0,4] [0,10]
        // [2,0] [2,4] [2,10]
        // [3,0] [3,4] [3,10]
        // [8,0] [8,4] [8,10]

//        Node[][] arr = new Node[garo.size()][sero.size()];
        Node[][] arr = new Node[sero.size()][garo.size()];

        for (int i = 0; i < sero.size(); i++) {
            for (int j = 0; j < garo.size(); j++) {
                arr[i][j] = new Node(sero.get(i), garo.get(j));
            }
        }

//        for (int i = 0; i < sero.size(); i++) {
//            for (int j = 0; j < garo.size(); j++) {
//                System.out.print(arr[i][j].r + " " + arr[i][j].c + " ");
//            }
//            System.out.println();
//        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < sero.size() - 1; i++) {
            for (int j = 0; j < garo.size() - 1; j++) {
                int se = arr[i + 1][j + 1].c - arr[i][j].c;
                int ga = arr[i + 1][j].r - arr[i][j].r;

                ans = Math.max(ans, se * ga);
            }
        }

        System.out.println(ans);
    }

}
